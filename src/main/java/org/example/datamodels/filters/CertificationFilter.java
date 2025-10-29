package org.example.datamodels.filters;

import org.example.datamodels.CertifiedCandidate;
import org.example.datamodels.interfaces.ICandidate;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class CertificationFilter {

    @Contract(pure = true)
    public static @NotNull Predicate<ICandidate> isCertified(){
        return candidate -> candidate.getClass() == CertifiedCandidate.class;
    }

   public static @NotNull Predicate<ICandidate> minimumCertifications(int i){
       return isCertified().and(
               candidate -> ((CertifiedCandidate) candidate).certificates().size() >= i
               );
   }



}
