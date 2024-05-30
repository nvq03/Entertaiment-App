package com.example.newsroom.domain.model

import com.example.newsroom.R

data class Foods(
    val imageId: Int,
    val name: String,
    val ingredients: String
)

val foodItems = listOf(
    Foods(
        imageId = R.drawable.p1,
        name = "Peperoni",
        ingredients = "Pepperoni is made from pork or from a mixture of pork and beef.Turkey meat is also commonly used as a substitute, but the use of poultry in pepperoni must be appropriately labeled in the United States. It is typically seasoned with paprika or other chili pepper.Prior to cooking, pepperoni is characteristically soft, slightly smoky, and bright red.Curing with nitrates or nitrites (usually used in modern curing agents to protect against botulism and other forms of microbiological decay) also contributes to pepperoni's reddish color, by reacting with heme in the myoglobin of the proteinaceous components of the meat."
    ),
    Foods(
        imageId = R.drawable.p2,
        name = "Dandan noodles",
        ingredients = "Jinsimian (金絲麵) or \"golden noodles\" is a variation of dandan noodles, invented by chef Li Hong-kai (李紅凱) in 1989. Using a special kneading technique, Li was able to create produces a flour noodle that has a non-sticky consistency when cooked even when cut super finely. The noodles are cut into a mass that can be passed through the needle. Li has entered the Guinness World Records for the most noodles passing through a needle, beaten by Li Enhai in 2010 when he added another hair. The latter also holds the record for the faintest noodle at 0.18 mm. As of 2024, there are also other chefs cooking dandan using jinsimian."
    ),
    Foods(
        imageId = R.drawable.p3,
        name = "Fried chicken",
        ingredients = "Fried chicken has been described as being \"crunchy\" and \"juicy\",as well as \"crispy\".The dish has also been called \"spicy\" and \"salty\".Occasionally, fried chicken is also topped with chili like paprika, or hot sauce to give it a spicy taste.This is especially common in fast food restaurant chains such as KFC.The dish is traditionally served with mashed potatoes, gravy, macaroni and cheese, coleslaw, corn or biscuits.\n" +
                "\n" +
                "The dish is renowned for being greasy, especially when coming from fast food outlets.It has even been reported that some of those who enjoy eating the food limit themselves to eating it only a certain number of times a year, to keep their fat intake reasonably low.Out of the various parts of the animal used in fried chicken, the wings generally tend to contain the most fat, with almost 40 grams (1.4 oz) of fat for every 100 grams (3.5 oz).[However, the average whole fried chicken contains only around 12% fat, or 12 grams (0.42 oz) per every 100 grams (3.5 oz).100 grams (3.5 oz) of fried chicken generally contains around 240 calories of energy."
    ),
    Foods(
        imageId = R.drawable.p4,
        name = "Banh My",
        ingredients = "In Vietnamese cuisine, bánh mì or banh mi is a short baguette with thin, crisp crust and a soft, airy texture. It is often split lengthwise and filled with meat and savory ingredients like a submarine sandwich and served as a meal, called bánh mì thịt. Plain bánh mì is also eaten as a staple food.\n" +
                "\n" +
                "A typical Vietnamese roll or sandwich is a fusion of meats and vegetables from native Vietnamese cuisine such as chả lụa (Vietnamese sausage), coriander (cilantro), cucumber, pickled carrots, and pickled daikon combined with condiments from French cuisine such as pâté, along with red chili and mayonnaise.However, a variety of popular fillings are used, from xá xíu (Chinese barbecued pork) to even ice cream. In Vietnam, bread rolls and sandwiches are typically eaten for breakfast or as a snack."
    ),
    Foods(
        imageId = R.drawable.p5,
        name = "Pho",
        ingredients = "Phở or Pho herbs, and meat (usually beef (phở bò)), sometimes chicken (phở gà).Phở is a popular food in Vietnam where it is served in households, street-stalls, and restaurants country-wide. Residents of the city of Nam Định were the first to create Vietnamese traditional phở. It is considered Vietnam's national dish.\n" +
                "\n" +
                "Phở originated in the early 20th century in Northern Vietnam, and after the Vietnam War, refugees popularized it throughout the world. Because phở's origins are poorly documented,there is disagreement over the cultural influences that led to its development in Vietnam, as well as the etymology of the name.The Hanoi (northern) and Saigon (southern) styles of pho differ by noodle width, sweetness of broth, and choice of herbs and sauce."
    ),
    Foods(
        imageId = R.drawable.p6,
        name = "Mexican",
        ingredients = "Mì Quảng (also spelled mỳ Quảng), literally \"Quảng noodles\", is a Vietnamese noodle dish that originated from Quảng Nam Province in central Vietnam. In the region, it is one of the most popular and nationally recognized food items, and is served on various occasions such as at family parties, death anniversaries, and Tết.\n" +
                "\n" +
                "Mì Quảng can both be found in many famous restaurants and street vendors among Central provinces and is eaten for breakfast and lunch.\n" +
                "\n" +
                "The main ingredients of mì Quảng are rice noodles, meat, and herbs, most commonly served with a small amount of broth, which is generally infused with turmeric. Peanut oil can also be added to make the dish more flavorful.Wide rice noodles are placed atop a bed of fresh herbs in a bowl (or vice versa), and then warm or lukewarm broth and meat are added. The broth is usually strongly flavored and only a small amount of it is used, generally enough to partially cover the vegetables.\n" +
                "\n" +
                "Meats used in the dish may include one or more of the following: shrimp (tôm), pork (thịt heo), chicken (gà), or even fish (cá) or beef (bò). The broth is made by simmering the meat in water or bone broth for a more intense flavor, seasoned with fish sauce, black pepper, shallot and garlic. Turmeric is often added to the broth, giving it a yellowish color."
    )

)