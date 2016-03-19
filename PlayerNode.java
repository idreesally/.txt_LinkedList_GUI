// PlayerNode.java

class PlayerNode
{
   BaseballPlayer data;
   PlayerNode next;

   PlayerNode(BaseballPlayer d)
   {
      data = d;
      next = null;
   }  // constructor
   
   public PlayerNode(BaseballPlayer d, PlayerNode n){
		data = d;
		next = n;
		
	}
   
}  // class PlayerNode

