package service;

import model.Product;

import java.util.*;

public class ProductServiceImpl implements ProductService, OptionService{
    private static Map<Integer,Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Coca", 10000, "Nước ngọt", "Coca cola"));
        products.put(2, new Product(2, "Pesi", 10000, "Nước ngọt", "Pesi"));
        products.put(3, new Product(3, "Hải Hà", 20000, "Bánh Kẹo", "Kinh đô"));
        products.put(4, new Product(4, "Thịt lợn", 30000, "Thực phẩm", "Hòa An"));
    }
    @Override
    public List<Product> findAll() {

        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product findByName(String name) {
        for (Product e: findAll() ) {
             if (e.getName().equals(name)){
                return e;
             }
         }
         return null;
    }
//    @Override
//     public Product findByName(String name){
//         for (Product e: findAll() ) {
//             if (e.getName().equals(name)){
//                return e;
//             }
//         }
//         return null;
//     }
//    @Override
//    public Product findByName(String name){
//        List<Product>listSearch = new ArrayList<>();
//        for (Product e: findAll() ) {
//            if (e.getName().equals(name)){
//                listSearch.add(e);
//            }
//        }
//        if (!listSearch.isEmpty()){
//            return (Product) listSearch;
//        }
//        return null;
//    }
}
