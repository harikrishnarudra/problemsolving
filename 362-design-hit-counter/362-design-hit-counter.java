class HitCounter {

    // private Map<Integer, Integer> map;
    private Queue<Integer> queue;
    private int constantTime = 300;

    public HitCounter() {
        // map = new TreeMap<>();
        queue = new LinkedList<>();
    }

    public void hit(int timestamp) {
        // map.put(timestamp, map.getOrDefault(timestamp,0)+1);
        queue.add(timestamp);
        // removeHitsBeyond(timestamp);
    }

    public int getHits(int timestamp) {
        // removeHitsBeyond(timestamp);
        int removableTimes = timestamp - constantTime;
        while(!queue.isEmpty()){
            if(queue.peek() <= removableTimes){
                queue.poll();
            }else{
                break;
            }
        }
        return queue.size();
    }

    
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */