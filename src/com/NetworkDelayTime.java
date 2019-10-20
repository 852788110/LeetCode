package com;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class NetworkDelayTime {
    class DirectedEdge{
        final int v;
        final int w;
        final int weight;
        public DirectedEdge(int v,int w,int weight){
            this.v=v;
            this.w=w;
            this.weight=weight;
        }
    }

    class EdgeWeightedDigraph{
        final int V;
        List<DirectedEdge>[] adj;
        public  EdgeWeightedDigraph(int V){
            this.V=V;
            this.adj=new List[V];
            for (int i=0;i<V;i++){
                adj[i]=new ArrayList<>();
            }
        }

        public void addEdge(int v,int w,int weight){
            DirectedEdge edge=new DirectedEdge(v,w,weight);
            adj[v].add(edge);
        }
    }

    class IndexMinPQ<Key extends Comparable<Key>>{
        private int maxN;        // maximum number of elements on PQ
        private int n;           // number of elements on PQ
        private int[] pq;        // binary heap using 1-based indexing
        private int[] qp;        // inverse of pq - qp[pq[i]] = pq[qp[i]] = i
        private Key[] keys;      // keys[i] = priority of i

        /**
         * Initializes an empty indexed priority queue with indices between {@code 0}
         * and {@code maxN - 1}.
         * @param  maxN the keys on this priority queue are index from {@code 0}
         *         {@code maxN - 1}
         * @throws IllegalArgumentException if {@code maxN < 0}
         */
        public IndexMinPQ(int maxN) {
            if (maxN < 0) {
                throw new IllegalArgumentException();
            }
            this.maxN = maxN;
            n = 0;
            keys = (Key[]) new Comparable[maxN + 1];    // make this of length maxN??
            pq   = new int[maxN + 1];
            qp   = new int[maxN + 1];                   // make this of length maxN??
            for (int i = 0; i <= maxN; i++) {
                qp[i] = -1;
            }
        }

        /**
         * Returns true if this priority queue is empty.
         *
         * @return {@code true} if this priority queue is empty;
         *         {@code false} otherwise
         */
        public boolean isEmpty() {
            return n == 0;
        }

        /**
         * Is {@code i} an index on this priority queue?
         *
         * @param  i an index
         * @return {@code true} if {@code i} is an index on this priority queue;
         *         {@code false} otherwise
         * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
         */
        public boolean contains(int i) {
            if (i < 0 || i >= maxN){ throw new IllegalArgumentException();}
            return qp[i] != -1;

        }

        /**
         * Returns the number of keys on this priority queue.
         *
         * @return the number of keys on this priority queue
         */
        public int size() {
            return n;
        }

        /**
         * Associates key with index {@code i}.
         *
         * @param  i an index
         * @param  key the key to associate with index {@code i}
         * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
         * @throws IllegalArgumentException if there already is an item associated
         *         with index {@code i}
         */
        public void insert(int i, Key key) {
            if (i < 0 || i >= maxN){ throw new IllegalArgumentException();}
            if (contains(i)){ throw new IllegalArgumentException("index is already in the priority queue");}
            n++;
            qp[i] = n;
            pq[n] = i;
            keys[i] = key;
            swim(n);
        }

        /**
         * Returns an index associated with a minimum key.
         *
         * @return an index associated with a minimum key
         * @throws NoSuchElementException if this priority queue is empty
         */
        public int minIndex() {
            if (n == 0) {throw new NoSuchElementException("Priority queue underflow");}
            return pq[1];
        }

        /**
         * Returns a minimum key.
         *
         * @return a minimum key
         * @throws NoSuchElementException if this priority queue is empty
         */
        public Key minKey() {
            if (n == 0){ throw new NoSuchElementException("Priority queue underflow");}
            return keys[pq[1]];
        }

        /**
         * Removes a minimum key and returns its associated index.
         * @return an index associated with a minimum key
         * @throws NoSuchElementException if this priority queue is empty
         */
        public int delMin() {
            if (n == 0){ throw new NoSuchElementException("Priority queue underflow");}
            int min = pq[1];
            exch(1, n--);
            sink(1);
            assert min == pq[n+1];
            qp[min] = -1;        // delete
            keys[min] = null;    // to help with garbage collection
            pq[n+1] = -1;        // not needed
            return min;
        }

        /**
         * Returns the key associated with index {@code i}.
         *
         * @param  i the index of the key to return
         * @return the key associated with index {@code i}
         * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
         * @throws NoSuchElementException no key is associated with index {@code i}
         */
        public Key keyOf(int i) {
            if (i < 0 || i >= maxN) {
                throw new IllegalArgumentException();
            }
            if (!contains(i)) {
                throw new NoSuchElementException("index is not in the priority queue");
            } else {
                return keys[i];
            }
        }
        /**
         * Change the key associated with index {@code i} to the specified value.
         *
         * @param  i the index of the key to change
         * @param  key change the key associated with index {@code i} to this key
         * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
         * @throws NoSuchElementException no key is associated with index {@code i}
         */
        public void changeKey(int i, Key key) {
            if (i < 0 || i >= maxN){ throw new IllegalArgumentException();}
            if (!contains(i)){ throw new NoSuchElementException("index is not in the priority queue");}
            keys[i] = key;
            swim(qp[i]);
            sink(qp[i]);
        }

        /**
         * Change the key associated with index {@code i} to the specified value.
         *
         * @param  i the index of the key to change
         * @param  key change the key associated with index {@code i} to this key
         * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
         * @deprecated Replaced by {@code changeKey(int, Key)}.
         */
        @Deprecated
        public void change(int i, Key key) {
            changeKey(i, key);
        }

        /**
         * Decrease the key associated with index {@code i} to the specified value.
         *
         * @param  i the index of the key to decrease
         * @param  key decrease the key associated with index {@code i} to this key
         * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
         * @throws IllegalArgumentException if {@code key >= keyOf(i)}
         * @throws NoSuchElementException no key is associated with index {@code i}
         */
        public void decreaseKey(int i, Key key) {
            if (i < 0 || i >= maxN){ throw new IllegalArgumentException();}
            if (!contains(i)){ throw new NoSuchElementException("index is not in the priority queue");}
            if (keys[i].compareTo(key) <= 0) {
                throw new IllegalArgumentException("Calling decreaseKey() with given argument would not strictly decrease the key");
            }
            keys[i] = key;
            swim(qp[i]);
        }

        /**
         * Increase the key associated with index {@code i} to the specified value.
         *
         * @param  i the index of the key to increase
         * @param  key increase the key associated with index {@code i} to this key
         * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
         * @throws IllegalArgumentException if {@code key <= keyOf(i)}
         * @throws NoSuchElementException no key is associated with index {@code i}
         */
        public void increaseKey(int i, Key key) {
            if (i < 0 || i >= maxN) {
                throw new IllegalArgumentException();
            }
            if (!contains(i)) {
                throw new NoSuchElementException("index is not in the priority queue");
            }
            if (keys[i].compareTo(key) >= 0) {
                throw new IllegalArgumentException("Calling increaseKey() with given argument would not strictly increase the key");
            }
            keys[i] = key;
            sink(qp[i]);
        }

        /**
         * Remove the key associated with index {@code i}.
         *
         * @param  i the index of the key to remove
         * @throws IllegalArgumentException unless {@code 0 <= i < maxN}
         * @throws NoSuchElementException no key is associated with index {@code i}
         */
        public void delete(int i) {
            if (i < 0 || i >= maxN) throw new IllegalArgumentException();
            if (!contains(i)) throw new NoSuchElementException("index is not in the priority queue");
            int index = qp[i];
            exch(index, n--);
            swim(index);
            sink(index);
            keys[i] = null;
            qp[i] = -1;
        }


        /***************************************************************************
         * General helper functions.
         ***************************************************************************/
        private boolean greater(int i, int j) {
            return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
        }

        private void exch(int i, int j) {
            int swap = pq[i];
            pq[i] = pq[j];
            pq[j] = swap;
            qp[pq[i]] = i;
            qp[pq[j]] = j;
        }


        /***************************************************************************
         * Heap helper functions.
         ***************************************************************************/
        private void swim(int k) {
            while (k > 1 && greater(k/2, k)) {
                exch(k, k/2);
                k = k/2;
            }
        }

        private void sink(int k) {
            while (2*k <= n) {
                int j = 2*k;
                if (j < n && greater(j, j+1)) {
                    j++;
                }
                if (!greater(k, j)) {
                    break;
                }
                exch(k, j);
                k = j;
            }
        }

    }
    private DirectedEdge[] edgeTo;
    private int[] distTo;
    private IndexMinPQ<Integer> pq;
    public int networkDelayTime(int[][] times, int N, int K) {
        EdgeWeightedDigraph G=new EdgeWeightedDigraph(N);
        for (int i=0;i<times.length;i++){
            int v=times[i][0]-1,w=times[i][1]-1,weight=times[i][2];
            G.addEdge(v,w,weight);
        }
        edgeTo=new DirectedEdge[N];
        distTo=new int[N];
        pq=new IndexMinPQ<>(N);

        for (int v=0;v<G.V;v++){
            distTo[v]=Integer.MAX_VALUE;
        }
        distTo[K-1]=0;
        pq.insert(K-1,0);
        while(!pq.isEmpty()){
            relax(G,pq.delMin());
        }

        int sum=0;
        for (int i=0;i<G.V;i++){
            if (distTo[i]>sum){
                sum=distTo[i];
            }
        }
        if (sum==Integer.MAX_VALUE){
            return -1;
        }
        return sum;
    }

    private void relax(EdgeWeightedDigraph G,int v){
        for (DirectedEdge e:G.adj[v]){
            int w=e.w;
            if (distTo[w]>distTo[v]+e.weight){
                distTo[w]=distTo[v]+e.weight;
                edgeTo[w]=e;
                if (pq.contains(w)){
                    pq.changeKey(w,distTo[w]);
                }else {
                    pq.insert(w,distTo[w]);
                }
            }
        }
    }
}
