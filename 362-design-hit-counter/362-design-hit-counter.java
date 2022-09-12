class HitCounter {

    private Queue<Integer> queue;
    private int constantTime = 300;

    public HitCounter() {
        queue = new LinkedList<>();
    }

    public void hit(int timestamp) {
        queue.add(timestamp);
    }

    public int getHits(int timestamp) {
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