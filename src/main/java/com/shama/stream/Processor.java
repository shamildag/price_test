/**
 * Naive Implementation based on stream :
 * Получаем списка старых цен и  новых цен на входе.
 * 1.отфильтровываем все с неправильной датой
 * 2.
 * 3. выделить  по составному ключу все элементы из старых и новых цен в подстримы
 * 4. сортировать по начальной дате
 * 5.Использовать условие пересечения old_begin < new_end &&  new_begin < old_end для того чтобы выделить
 *  а. новые цены которые не пересекаются с прежними совсем
 *  б. новые цены которые поглощают старые
 *  в. новые цены которые делать диапазон старых
 *
 *
 */
package com.shama.stream;

import com.shama.model.Price;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class Processor {
    public static Stream<Price> processNewPrices(List<Price> oldPrices, List<Price> newPrices) {
        Stream<Price> result = newPrices.stream()
                .flatMap(
                        (price -> oldPrices.stream().sorted(priceDateComparator)
                                .filter(price_old -> hasTheSameCompositeKey.test(price_old, price))
//                                .filter(price_old -> price.getProduct_code().equalsIgnoreCase(price_old.getProduct_code())
//                                        && price.getDepart() == price_old.getDepart()
//                                        && price.getNumber() == price_old.getNumber())
//								.flatMap(price_old -> {
//									price_old.begin >
//								}))
                ));


        return result;
    }

    //
    public static BiFunction<Price, Stream<Price>, Stream<Price>> processDuration =
            (Price old, Stream<Price> newPrices) -> {
//                newPrices.sorted(priceDateComparator);
//                return newPrices.flatMap((String s) -> Arrays.stream(new String[]{"svsv", "sdvsdv", old}));
//		Stream <Price> result = null;

//		return result;
            };
public static Stream<Price> sortNewPrices (Stream<Price > prices ) {
    return prices.sorted(priceDateComparator);
}
    // Comparator по begin data
    public static Comparator<Price> priceDateComparator = Comparator.comparing(Price::getBegin);
    // Проверка составного  ключа департамент + номер цены + код продукта
    public static BiPredicate<Price, Price> hasTheSameCompositeKey = (price1, price2) -> price1.getProduct_code().equalsIgnoreCase(price2.getProduct_code())
            && price1.getDepart() == price2.getDepart()
            && price1.getNumber() == price2.getNumber();
}
