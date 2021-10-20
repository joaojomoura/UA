for nrHead = 0 : 20
    resultado(nrHead+1) = prob_sim(0.8,20,nrHead,1e5);
end

stem(resultado)