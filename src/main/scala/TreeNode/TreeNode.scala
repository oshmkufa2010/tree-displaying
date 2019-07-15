package TreeNode

case class TreeNode[T](data: T, children: Seq[TreeNode[T]] = Nil)

object TreeNode {
  def asciiDisplay(root: TreeNode[String]): Seq[String] = {
    display(root, "", false)
  }

  private def display(root: TreeNode[String], prefix: String, hasNext: Boolean): Seq[String] = {
    (prefix ++ "+-" ++ root.data) +: (if (hasNext) {
      displayChildren(root.children, prefix ++ "| ") ++ (if (root.children.length > 0) Seq(prefix ++ "|") else Seq())
    } else {
        displayChildren(root.children, prefix ++ "  ")
    })
  }

  private def displayChildren(children: Seq[TreeNode[String]], prefix: String): Seq[String] = children match {
    case Seq() => Seq()
    case Seq(x) => display(x, prefix, false)
    case x +: xs => display(x, prefix, true) ++ displayChildren(xs, prefix)
  }
}
