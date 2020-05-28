import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class MyForker<T> {
	private Stream<T> stream;
	private Map<Object, Function<Stream<T>, ?>> forks=new HashMap<>();
	
	public MyForker(Stream<T> stream) {
		this.stream=stream;
	}
	
	public MyForker<T> fork(Object key, Function<Stream<T>, ?> f){
		forks.put(key, f);
		return this;
	}
	
	public Result getResult() {
		ForkingStreamConsumer<T> consume=build();
		try {
			stream.sequential().forEach(consume);
		}catch(Exception e) {
			
		}
		finally {
			consume.finish();
		}
		return consume;
	}
	
	private ForkingStreamConsumer<T> build() {
		List<BlockingQueue<T>> queue=new ArrayList<>();
		Map<Object,Future<?>> actions=forks.entrySet().stream().reduce(
					new HashMap<Object,Future<?>>(),(map,e)->{
						map.put(e.getKey(),getOperationResult(queue,e.getValue()));
						return map;
					},(m1,m2)->{
						m1.putAll(m2);
						return m1;
					}
				);
		return new ForkingStreamConsumer<>(queue,actions);
	}

	private Future<?> getOperationResult(List<BlockingQueue<T>> queues, Function<Stream<T>, ?> f) {
		BlockingQueue<T> queue=new LinkedBlockingQueue<>();
		
		queues.add(queue);
		Spliterator<T> sp=new BlockingQueueSpliterator<>(queue);
		Stream<T> ss=StreamSupport.stream(sp, false);
		
		return CompletableFuture.supplyAsync(()->f.apply((ss)));
	}
	
	public static interface Result{
		public <R> R get(Object key);
	}

	private static class ForkingStreamConsumer<T> implements Consumer<T>,Result{
		
		static final Object END_OF_STREAM=new Object();
		private List<BlockingQueue<T>> queues;
		private Map<Object,Future<?>> actions;
		
		ForkingStreamConsumer(List<BlockingQueue<T>> queues,Map<Object,Future<?>> actions){
			this.queues=queues;
			this.actions=actions;
		}

		@Override
		public <R> R get(Object key) {
			try {
				return ((Future<R>)actions.get(key)).get();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public void accept(T t) {
			queues.forEach(q->q.add(t));
			
		}
		void finish() {
			accept((T) END_OF_STREAM);
		}
		
	}
	
	private static class BlockingQueueSpliterator<T> implements Spliterator<T>{
		
		private final BlockingQueue<T> q;
		
		BlockingQueueSpliterator(BlockingQueue<T> q){
			this.q=q;
		}

		@Override
		public int characteristics() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public long estimateSize() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean tryAdvance(Consumer<? super T> action) {
			// TODO Auto-generated method stub
			T t;
			while(true) {
				try {
					t=q.take();
					break;
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(t!=ForkingStreamConsumer.END_OF_STREAM) {
				action.accept(t);
				return true;
			}
			return false;
		}

		@Override
		public Spliterator<T> trySplit() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
}













