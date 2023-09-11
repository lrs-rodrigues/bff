package com.lrsrodrigues.bffasyncstopm.domain.gateway;

import com.lrsrodrigues.bffasyncstopm.domain.entity.resale.ResaleCommission;
import com.lrsrodrigues.bffasyncstopm.domain.entity.resale.ResaleDetails;

public interface ResaleGateway {

    ResaleDetails getDetailsByDocument(String document);

    ResaleCommission getCommissionsByDocument(String document);

}
