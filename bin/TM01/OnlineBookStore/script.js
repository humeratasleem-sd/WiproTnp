body {
    margin: 0;
    font-family: Arial, sans-serif;
    background-color: white;
}

.container {
    width: 90%;
    margin: auto;
}


/* ================= FIRST ROW ================= */

.promotion {
    width: 100%;
    height: 180px;

    background-color: #e59ad5;

    display: flex;
    align-items: center;
    justify-content: center;

    position: relative;

    margin-top: 20px;
}

.promotion-text {
    text-align: center;
}

.promotion-text h1 {
    font-size: 20px;
    margin: 5px;
    text-transform: uppercase;
}

.promotion-text h2 {
    font-size: 30px;
    margin: 5px;
    text-transform: uppercase;
}

.promotion-text p {
    font-size: 18px;
    margin: 5px;
    text-transform: lowercase;
}


/* Round logo */

.logo {
    width: 70px;
    height: 70px;

    border-radius: 50%;

    background-color: white;

    display: flex;
    justify-content: center;
    align-items: center;

    font-size: 35px;

    margin-left: 40px;
}


/* ================= SECOND ROW ================= */

.menu {
    display: flex;

    justify-content: center;

    gap: 20px;

    padding: 20px;

    border-bottom: 1px solid gray;
}

.menu button {
    padding: 10px 25px;

    background-color: white;

    border: 1px solid gray;

    font-size: 16px;

    cursor: pointer;
}

.menu button:hover {
    background-color: lightgray;
}


/* ================= SECTION TITLE ================= */

.section-title {
    border-bottom: 1px solid gray;

    padding-bottom: 8px;

    margin-top: 30px;

    font-size: 18px;
}


/* ================= BOOK GRID ================= */

.book-grid {
    display: grid;

    grid-template-columns: repeat(6, 1fr);

    gap: 20px;

    margin-top: 20px;
}


.book {
    text-align: center;

    padding: 10px;
}

.book img {
    width: 120px;

    height: 160px;

    object-fit: cover;

    border-radius: 10px;

    box-shadow: 0 2px 5px gray;
}

.book h3 {
    font-size: 15px;

    margin-top: 10px;

    margin-bottom: 5px;
}

.book p {
    font-size: 13px;

    margin-top: 0;

    color: gray;
}


/* ================= NEW RELEASE ================= */

.new-release {
    text-align: center;

    padding: 20px;

    border: 1px solid lightgray;

    margin-bottom: 30px;
}


/* ================= RESPONSIVE ================= */

@media screen and (max-width: 1000px) {

    .book-grid {
        grid-template-columns: repeat(3, 1fr);
    }

}


@media screen and (max-width: 600px) {

    .book-grid {
        grid-template-columns: repeat(2, 1fr);
    }

    .promotion {
        height: auto;

        padding: 30px 10px;
    }

    .menu {
        flex-direction: column;
    }

}