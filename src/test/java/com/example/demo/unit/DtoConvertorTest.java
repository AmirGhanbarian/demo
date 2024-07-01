package com.example.demo.unit;

import com.example.demo.StaticTestDataFactory;
import com.example.demo.helper.DtoConvertor;
import lombok.val;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DtoConvertorTest {

    @Test
    public void addressDtoListToAddressListTest() {

        val addressDtoTestList = StaticTestDataFactory.getTestAddressDto();
        var result = DtoConvertor.addressDtoListToAddressList(addressDtoTestList);

        assertThat(result.size()).isEqualTo(addressDtoTestList.size());
        assertThat(result.get(0).getAddress()).isEqualTo(addressDtoTestList.get(0).getAddress());

        result = DtoConvertor.addressDtoListToAddressList(null);
        assertThat(result.isEmpty()).isTrue();

    }
}
