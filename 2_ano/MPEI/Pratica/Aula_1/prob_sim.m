
function f = prob_sim(p,nlanc,ncaras,N)

    lancamentos = rand(nlanc,N) < p;
    sucessos = sum(lancamentos) <= ncaras;
    f = sum(sucessos)/N;

end

