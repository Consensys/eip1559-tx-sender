package tech.pegasys.net.core.batch;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

import com.google.common.collect.EvictingQueue;

public class TransactionQueue {

  private final Queue<String> transactions;
  private final int maxSize;
  private final Consumer<List<String>> onFlushAction;

  public TransactionQueue(final int maxSize, final Consumer<List<String>> onFlushAction) {
    this.maxSize = maxSize;
    transactions = EvictingQueue.create(maxSize);
    this.onFlushAction = onFlushAction;
  }

  public void add(final String transaction) {
    synchronized (transactions) {
      if (transactions.size() == maxSize) {
        flush();
      }
      transactions.add(transaction);
    }
  }

  public void flush() {
    synchronized (transactions) {
      final List<String> transactionsToFlush = new ArrayList<>();
      while (!transactions.isEmpty()) {
        transactionsToFlush.add(transactions.poll());
      }
      onFlushAction.accept(transactionsToFlush);
    }
  }
}
