package algo;

public class Student implements Comparable<Student>{

    private String Name;
    private int Score;

    public Student(String name, int score){
        this.Name = name;
        this.Score = score;
    }

    @Override
    public int compareTo (Student that){
        if(this.Score > that.Score){
            return 1;
        }else if(this.Score < that.Score){
            return -1;
        }else
            return this.Name.compareTo(that.Name);
    }

    @Override
    public String toString(){
        return "Student" + this.Name + " " + this.Score;
    }

}
