package org.example.datamodels.filters;

import org.example.datamodels.CertifiedCandidate;
import org.example.datamodels.interfaces.ICandidate;

public class HasNumberOfCertificationsFilter implements FilterPolicy<Integer>{

    public boolean policy(ICandidate a, Integer filter) {

        if(filter < 1){
            throw new NumberFormatException("Filter Must be positive-nonzero value");
        }

        if(a.getClass() != CertifiedCandidate.class){
            return false;
        }else{
            return ((CertifiedCandidate) a).certificates().size() >= filter;
        }


    }
}
