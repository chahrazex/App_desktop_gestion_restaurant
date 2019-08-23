package Model;

public class Meals {
    int num,cost ;
    String name ,type ;

    public Meals(int num, String name, String type, int cost) {
        this.num = num;

        this.name = name;
        this.type = type;
        this.cost = cost;
    }

    public int getNum() {
        return num;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
