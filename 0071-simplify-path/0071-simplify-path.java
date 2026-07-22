class Solution {
    public String simplifyPath(String path) {
        Stack<String> stk = new Stack<>();
        String parts[] = path.split("/");
        for(String part : parts)
        {
            if(part.equals("") || part.equals(".")) continue;
            if (part.equals(".."))
            {
                if(!stk.isEmpty()) stk.pop(); // moving  tp previous directory
            }
            else{
                stk.push(part);
            }
            
        }
        if(stk.isEmpty()) return "/";
        StringBuilder res = new StringBuilder();
        for(String dir : stk)
        {
            res.append("/").append(dir);
            
        }
        return res.toString();
}
}