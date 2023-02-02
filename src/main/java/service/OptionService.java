package service;

import model.Product;

public interface OptionService {
    Product findByName(String name);
}
