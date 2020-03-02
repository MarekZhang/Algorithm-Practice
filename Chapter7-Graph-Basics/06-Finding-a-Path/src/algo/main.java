package algo;

public class main{
    public static void main(String[] args){

        // 使用两种图的存储方式读取testG1.txt文件
        String filename = "testG.txt";
        SparseGraph g1 = new SparseGraph(7, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename);

        DenseGraph g2 = new DenseGraph(7, false);
        ReadGraph readGraph2 = new ReadGraph(g2 , filename );

        g1.show();
        g2.show();
        Path path = new Path(g1, 3);
        path.showPath(6);
        System.out.println();
        for (boolean b: path.getVisited()){
            System.out.print(b + " ");
        }
    }
}