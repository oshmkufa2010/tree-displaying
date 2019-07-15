package TreeNode

import org.scalatest._

class TreeNodeSpec extends FlatSpec with Matchers {


    TreeNode.asciiDisplay(TreeNode("Root",
      children = Seq(TreeNode("level1-1"),
        TreeNode("level1-2"),
        TreeNode("level1-3")))) shouldBe Seq("+-Root", "  +-level1-1", "  +-level1-2", "  +-level1-3")

    TreeNode.asciiDisplay(TreeNode("Root",
      children = List(
        TreeNode("level1-1", children = TreeNode("level2-1", children = TreeNode("level3-1") :: Nil) :: Nil),
        TreeNode("level1-2"),
        TreeNode("level1-3")))) shouldBe Seq("+-Root", "  +-level1-1", "  | +-level2-1", "  |   +-level3-1", "  |", "  +-level1-2", "  +-level1-3")

}

