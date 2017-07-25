def f(num:Int,arr:List[Int]):List[Int] = {
    
    for {
        n <- arr        
        x <- 1 to num
    } yield n
}



