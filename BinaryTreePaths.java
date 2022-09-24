import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(BNode root) {

        List<String> pathList = new ArrayList<>();

        String path = "";
        dfs(root,pathList,path);
        return pathList;
    }

    public void dfs(BNode root,List<String> pathList,String path){
        path += root.data;

        if(root.left ==null && root.right==null){
            pathList.add(path);
            return;
        }


        if(root.left != null){

            dfs(root.left,pathList,path+"->");
        }

        if(root.right != null){
            dfs(root.right,pathList,path+"->");
        }


    }
}
