package com.xipengyuan.demo.jpa.persistence.repository.dao;

import java.util.List;

public interface AddressDao {

    List<String> findDistrictsByProvinceAndCity(String province, String city);
}
