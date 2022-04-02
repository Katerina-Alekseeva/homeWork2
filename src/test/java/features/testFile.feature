Feature: Тестирование яндекс марткета

  Scenario Outline: Проверка соответствия результатов поиска установленным фильтрам
    Given open Yandex main page
    And go to Yandex servis '<servis>'
    Then open Menu
    Then select a section '<sectionName>'
    And select a subsection '<subsectionName>'
    When set filters for price '<minPrice>''<maxPrice>' and model '<model1>' '<model2>'
    And set the number 12 of items  per page
    Then check that the number of elements is 12
    Then  check that the corresponding product is being searched for by the name of the first element
Then  Equals results
    Examples:
      | servis | sectionName | subsectionName | minPrice | maxPrice | model1 | model2 |  |
      | Маркет | Компьютеры  | Ноутбуки       | 10000    | 90000    | HP     | Lenovo |  |



