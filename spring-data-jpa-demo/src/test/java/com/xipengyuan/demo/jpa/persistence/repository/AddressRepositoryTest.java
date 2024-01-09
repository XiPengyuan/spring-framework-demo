package com.xipengyuan.demo.jpa.persistence.repository;

import com.xipengyuan.demo.jpa.config.PersistenceConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(PersistenceConfig.class)
class AddressRepositoryTest {

    @Autowired
    AddressRepository addressRepository;

    @Test
    void testFindDistrictsByProvinceAndCity() {
        List<String> districts = addressRepository.findDistrictsByProvinceAndCity("江苏", null);
        assertThat(districts).hasSameElementsAs(List.of("鼓楼区", "姑苏区"));

        districts = addressRepository.findDistrictsByProvinceAndCity("江苏", "苏州");
        assertThat(districts).hasSameElementsAs(List.of("姑苏区"));
    }
}
