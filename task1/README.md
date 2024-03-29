# jwork-2021

## 类图如下

![example](http://www.plantuml.com/plantuml/png/TLEzSjim3Dxr51pbStnNvwv3jZHBbWozkktIwq3BgCAM8dKas3RDvTqBWP0AERK74__uy06wpMWJbi6R_St--lhD_krDqxY0aBxP3imX9XBDSsFezpEwa_7HdjeDwvcS8lQ0xxqDfBtez0SNxD63piyK6RD35uFapYeN4RaMwhpDsToL8zKG96uOFGmGC0ksMdf7FRzyDROg1qmkz6OaH6pO_aCkSHjbpx_iEDcDkvh-lskV6d4hLVMeWl0UuC-2v3cZHTUzYDNW8rJf_sugzt6Ea4wxjIQJrqTZ0wosLY8oFskqtWNuDBOFzB2yqGmH4wDD6NWUHPe4SHVu3Lr1cDqPOUJ98PJ1tCUIJdedid2XOjdiA0AREOa9JrTcUlhw70Nvp91K9u9Ok7lwOCEFcaU21C_gsP8mLc4slpgzLz0ayC8nhgzbSLI4DaHQSbA8AFcpzGNqaH0rmijs4daG3w77nysQhMah8cRLU2pO2ht6rxVovgInEAVczPnLyxcsBEQipkepF6zong1uBqHTe5-2QJACxrAoJvgOGmV2ZDezjnki2-rogZRrcTFucBUxtGAvQMuXdChW_m80)

## 时序图如下

![timeline](http://www.plantuml.com/plantuml/png/SoWkIImgAStDKJ2qD3GoCZ0qjUJYIamkoIzIACb8TKzDhKejuk9ApIl9BAbKACulAa7Y-cJcfS8KbnTb8albvATpSO7aTUr0f9N2qpahdkneVh9ZrPEzlS_thdlQqVQqO_MpAVk0R8ZuYuchNtGjUxgYcOiBRh62hXtKJYk55nkQdqzPKPnQ4WmMUB-d1yG5ivEVTinzkhpxQS-q5-shdcxV-7nM2qG2rIYmUs46vG3PfGL0KrwiMudcW6TzarxEc8-g5-GXe2Ssj47q0MruiN_AqzdpdZRiUR6r-_dkcM0FWmC1eHp2VTOv-MdlXgVjku1YJ_OlVDQu7baXX6Mba9PJMfo1JI8v9xyO6CeEgNafm5W20000)

## 好处与可改进之处

1. 好处：
   1. 实现了对客观世界描述到软件结构的直接转换 ：“老爷爷指挥七个葫芦娃按排行顺序站成一队”，其中老爷爷、葫芦娃、排行、排序器分别对应一个类，葫芦娃随机排成一行后，老爷爷加载排序器，通过它对葫芦娃们进行排序，并获取排序器给出的交换信息。各类的功能均对应于动漫中个体的功能，划分清晰。
   2. 封装良好，使得代码便于添加与改动：例如通过sort()接口可以很好的添加其他方式的排序器进行优化；通过linable(0)接口使得易于将一维数组拓展到高维等。
   3. 不同结构间的低耦合性提高了代码的可移植性和可拓展性。
2. 可改进之处：
   1. Gourd（）类作为枚举类，可以实现的数据范围有限（因为太多会列举不过来），所以后面任务用普通类取代。