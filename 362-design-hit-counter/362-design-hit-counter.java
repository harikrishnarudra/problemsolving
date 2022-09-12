class HitCounter {

    private Map<Integer, Integer> map;
    private Queue<Integer> queue;
    private int constantTime = 300;

    public HitCounter() {
        map = new TreeMap<>();
        queue = new LinkedList<>();
    }

    public void hit(int timestamp) {
        map.put(timestamp, map.getOrDefault(timestamp,0)+1);
        queue.add(timestamp);
        removeHitsBeyond(timestamp);
    }

    public int getHits(int timestamp) {
        removeHitsBeyond(timestamp);
        return queue.size();
    }

    private void removeHitsBeyond(int timeStamp){
        int removableTimes = timeStamp - constantTime;
        List<Integer> list = new ArrayList<>();
        for(int key:map.keySet()){
            if(key > removableTimes){
                break;
            }else{
                int cnt = map.get(key);
                while(cnt > 0){
                    queue.poll();
                    cnt--;
                }
                list.add(key);
            }
        }
        for(int i=0; i< list.size(); i++){
            map.remove(list.get(i));
        }
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */