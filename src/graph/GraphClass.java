package graph;

import java.util.*;

public class GraphClass <T>{
    protected Map<T, List<T>> map;
    protected boolean isUnidirectional;

    public GraphClass(boolean isUnidirectional) {
        this.map = new HashMap<>();
        this.isUnidirectional = isUnidirectional;
    }

    public void AddVertex(T v){
        map.put(v, new LinkedList<T>());
    }

    public void AddEdge(T start, T end){
        if(!hasVertex(start)){
            AddVertex(start);
        }
        if(!hasVertex(end)){
            AddVertex(end);
        }

        map.get(start).add(end);

        //En caso sea unidireccional
        if(isUnidirectional){
            map.get(end).add(start);
        }
    }

    public int getEdgesCount(){
        int count = 0;

        for(T e: map.keySet()){
            count += map.get(e).size();
        }

        //Remove duplicated edges
        if(isUnidirectional){
            count /= 2;
        }

        return count;
    }

    public boolean hasVertex(T v){
        return map.containsKey(v);
    }

    public boolean hasEdge(T start, T end){
        return map.get(start).contains(end);
    }

    public void PrintGraph(){
        System.out.println(map);
    }

    public boolean PersonIsSeller(T person){
        String per = (String)person;
        if(per.charAt(per.length() - 1) == 'm'){
            return true;
        }
        return  false;
    }

    public boolean SearchMangoSeller(T name){
        Queue<T> search = new ArrayDeque<>();

        for(T item: map.get(name)){
            search.add(item);
        }

        List<T> searched = new LinkedList<>();

        while(!search.isEmpty()){
            T item = search.poll();
            if(!searched.contains(item)){
                if(PersonIsSeller(item)){
                    System.out.println((String)item + " is  a mango seller!!");
                    return true;
                }else{
                    searched.add(item);
                    System.out.println("Item map = " + map.get(item));
                    for(T edge: map.get(item)){
                        if(!searched.contains(edge)){
                            search.add(edge);
                        }
                    }
                }
            }
        }
        return false;
    }

    public void BFSPrint(T name){
        Queue<T> search = new LinkedList<>();
        Set<T> seen = new HashSet<>();
        search.add(name);
        while(!search.isEmpty()){
            T curr = search.poll();
            if(!seen.contains(curr)){
                seen.add(curr);
                System.out.println("current = " + curr);
            }
            for(T adjacent: map.get(curr)){
                if(!seen.contains(adjacent)){
                    search.add(adjacent);
                }
            }
        }
    }
}
