import java.util.*;

/*
Task:

        You work on a team whose job is to understand the most sought after toys for the holiday season. A teammate of yours has built a webcrawler that extracts a list of quotes about toys from different articles. You need to take these quotes and identify which toys are mentioned most frequently. Write an algorithm that identifies the top N toys out of a list of quotes and list of toys.

        Your algorithm should output the top N toys mentioned most frequently in the quotes.

        Input:

        The input to the function/method consists of five arguments:

        numToys, an integer representing the number of toys
        topToys, an integer representing the number of top toys your algorithm needs to return;
        toys, a list of strings representing the toys,
        numQuotes, an integer representing the number of quotes about toys;
        quotes, a list of strings that consists of space-sperated words representing articles about toys
        Output:

        Return a list of strings of the most popular N toys in order of most to least frequently mentioned

        Note:

        The comparison of strings is case-insensitive. If the value of topToys is more than the number of toys, return the names of only the toys mentioned in the quotes. If toys are mentioned an equal number of times in quotes, sort alphabetically.


example: topToys: 2,
    toys: ["elmo", "elsa", "legos", "drone", "tablet", "warcraft"],
    quotes: [
      "Emo is the hottest of the season! Elmo will be on every kid's wishlist!",
      "The new Elmo dolls are super high quality",
      "Expect the Elsa dolls to be very popular this year",
      "Elsa and Elmo are the toys I'll be buying for my kids",
      "For parents of older kids, look into buying them a drone",
      "Warcraft is slowly rising in popularity ahead of the holiday season"
    ],
    expected: ["elmo", "elsa"]


*/




public class NumberOfToys{


    public static void main(String[] args){

        String[] toys = {"elmo", "elsa", "legos", "drone", "tablet", "warcraft"};
        String[] quotes = {"Emo is the hottest of the season! Elmo will be on every kid's wishlist!",
                "The new Elmo dolls are super high quality",
                "Expect the Elsa dolls to be very popular this year",
                "Elsa and Elmo are the toys I'll be buying for my kids",
                "For parents of older kids, look into buying them a drone",
                "Warcraft is slowly rising in popularity ahead of the holiday season"};

        ArrayList<String> output = popularNToys2(6, 4, Arrays.asList(toys), 6, Arrays.asList(quotes));

        for(String toyName: output){
            System.out.println("\n"+toyName);
        }

    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static ArrayList<String> popularNToys(int numToys,
                                          int topToys,
                                          List<String> toys,
                                          int numQuotes,
                                          List<String> quotes)
    {

        ArrayList<String> output = new ArrayList<String>();

        if(numToys == 0 || numQuotes ==0 || topToys ==0){
            return output;
        }

        HashMap<String, Integer> toysMap = new HashMap<String, Integer>();
        for (int i=0; i< numQuotes; i++){
            String quote = quotes.get(i);

            for(int j=0; j< numToys; j++){
                String toyName = toys.get(j);
                quote.replaceAll(toyName, "1 "+ toyName + " 1");
                String[] split1 = quote.split(toyName);
                // int nameCount = split1.length;
                // if(nameCount > 1){
                //     nameCount--;
                // }
                if(quote.contains(toyName)){
                    if(!toysMap.containsKey(toyName)){
                        toysMap.put(toyName, split1.length);
                    }else{
                        int num = toysMap.get(toyName)+(split1.length) ;
                        toysMap.put(toyName, num);
                    }
                }
            }
        }

        List<Map.Entry<String,Integer>> inputList = new ArrayList<Map.Entry<String,Integer>>(toysMap.entrySet());
        Collections.sort(inputList, new Comparator<Map.Entry<String,Integer>>(){

            public int compare(Map.Entry<String,Integer> obj1, Map.Entry<String,Integer> obj2){
                return obj1.getValue().compareTo(obj2.getValue());
            }


        });


        int lastindex = inputList.size()-1;
        for(int i=0; i<topToys && i< inputList.size(); i++){
            output.add(inputList.get(lastindex).getKey());
            lastindex--;
        }

        return output;

    }

    public static ArrayList<String> popularNToys2(int numToys,
                                          int topToys,
                                          List<String> toys,
                                          int numQuotes,
                                          List<String> quotes){


        ArrayList<String> output = new ArrayList<String>();

        // Maintain hashmap for toys list , complexity: T(List of Toys)
        HashMap<String, Integer> toysMap = new HashMap<String, Integer>();
        for(String toyName : toys){
            toyName = toyName.toLowerCase();
            toysMap.put(toyName,0);
        }

        //maintain Count of Toys Word in map, Complexity: Q(List of Quotes)*W(Number of Words in Each Quote)
        int wordCount;
        for(String quote: quotes){
            String[] words = quote.split(" ");
            for(String word: words){
                word = word.toLowerCase();
                if(toysMap.containsKey(word)){
                    wordCount = toysMap.get(word);
                    toysMap.put(word, ++wordCount);
                }
            }
        }

        // Build MinHeap for calculating topToys, complexity: T(ToysMap Traverse)*slogs(s=queueSize)
        int queueSize = toys.size()>topToys?topToys:toys.size();
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                return obj1.getValue().compareTo(obj2.getValue());
            }
        });
        for(Map.Entry<String, Integer> entry: toysMap.entrySet()){
            if(!queue.isEmpty() && queue.peek()!=null && queue.size()==queueSize){
                if(entry.getValue()>queue.peek().getValue()){
                    queue.poll();
                    queue.offer(entry);
                }
            }else{
                queue.offer(entry);
            }
        }

        // Print Output List, Complexit= s(queueSize)
        while(!queue.isEmpty()){
            output.add(0, queue.poll().getKey());
        }

        return output;

    }

}
