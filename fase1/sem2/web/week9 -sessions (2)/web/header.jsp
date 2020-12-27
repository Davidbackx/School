<header>
    <h1>
        <span>Web shop</span>
    </h1>
    <nav>
        <ul>
            <li ${param.page eq 'Home'?'id="actual"':""}>
                <a href="Controller?command=home">Home</a></li>
            <li ${param.page eq 'Product Overview'?'id="actual"':''}>
                <a href="Controller?command=overview">Overview</a>
            </li>
            <li id="shoppingCart"><a href="Controller?command=showCart">Shopping Cart</a></li>
        </ul>
    </nav>
    <h2>${param.page}</h2>
</header>