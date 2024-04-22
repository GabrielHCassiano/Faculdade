package app;

public class Main {
    public static void main(String[] args) {
        /*Grafo g = new Grafo();

        Vertice v1 = new Vertice ("1");
        g.adicionarVertice(v1);
        Vertice v2 = new Vertice ("2");
        g.adicionarVertice(v2);
        Vertice v3 = new Vertice ("3");
        g.adicionarVertice(v3);
        Vertice v4 = new Vertice ("4");
        g.adicionarVertice(v4);


        g.adicionarAresta(new Aresta("a1", v1, v2));

        g.adicionarAresta(new Aresta("a2", v1, v4));
        g.adicionarAresta(new Aresta("a3", v2, v1));
        g.adicionarAresta(new Aresta("a4", v3, v4));

        g.verificaAdjacencias();
        g.printaMatrizAdjacencias();
        g.printaMatrizIncidencia();
        System.out.println(g);
        */
    	
    	Grafo grafoEstados = new Grafo();
    	
    	String[] nomesEstados = {
    			"Aracajú",
    			"Belém",
    			"Belo Horizonte",
    			"Boa Vista",
    			"Brasília",
    			"Campo Grande",
    			"Cuiabá",
    			"Curitiba",
    			"Florianópolis",
    			"Fortaleza",
    			"Goiânia",
    			"João Pessoa",
    			"Maceió",
    			"Manaus",
    			"Natal",
    			"Palmas",
    			"Porto Alegre",
    			"Porto Velho",
    			"Recife",
    			"Rio Branco",
    			"Rio de Janeiro",
    			"Salvador",
    			"São Luis",
    			"São Paulo",
    			"Teresina",
    			"Vitória"
    	};
    	
    	Vertice[] verticeEstados = new Vertice[nomesEstados.length];
    	
    	for (int i = 0; i < nomesEstados.length; i++)
    		verticeEstados[i] = new Vertice(nomesEstados[i]);
    	
    	grafoEstados.adicionarVertice(verticeEstados);
    	
    	for (int l = 0; l < nomesEstados.length; l++) {
        	for (int c = 0; c < nomesEstados.length; c++) {
        		
	        	int distancia = 0;
	        	
	        	switch(verticeEstados[l].getNome() + ":" + verticeEstados[c].getNome())
	        	{
	        		case "Aracajú:Aracajú": distancia = 0; break;
	        		case "Belém:Aracajú": distancia = 2079; break;
	        		case "Belém:Belém": distancia = 0; break;
	        		case "Belo Horizonte:Aracajú": distancia = 1578; break;
	        		case "Belo Horizonte:Belém": distancia = 2824; break;
	        		case "Belo Horizonte:Belo Horizonte": distancia = 0; break;
	        		case "Boa Vista:Aracajú": distancia = 6000; break;
	        		case "Boa Vista:Belém": distancia = 6083; break;
	        		case "Boa Vista:Belo Horizonte": distancia = 4736; break;
	        		case "Boa Vista:Boa Vista": distancia = 0; break;
	        		case "Brasília:Aracajú": distancia = 1652; break;
	        		case "Brasília:Belém": distancia = 2120; break;
	        		case "Brasília:Belo Horizonte": distancia = 716; break;
	        		case "Brasília:Boa Vista": distancia = 4275; break;
	        		case "Brasília:Brasília": distancia = 0; break;
	        		case "Campo Grande:Aracajú": distancia = 2765; break;
	        		case "Campo Grande:Belém": distancia = 2942; break;
	        		case "Campo Grande:Belo Horizonte": distancia = 1453; break;
	        		case "Campo Grande:Boa Vista": distancia = 3836; break;
	        		case "Campo Grande:Brasília": distancia = 1134; break;
	        		case "Campo Grande:Campo Grande": distancia = 0; break;
	        		case "Cuiabá:Aracajú": distancia = 2775; break;
	        		case "Cuiabá:Belém": distancia = 2941; break;
	        		case "Cuiabá:Belo Horizonte": distancia = 1594; break;
	        		case "Cuiabá:Boa Vista": distancia = 3142; break;
	        		case "Cuiabá:Brasília": distancia = 1133; break;
	        		case "Cuiabá:Campo Grande": distancia = 694; break;
	        		case "Cuiabá:Cuiabá": distancia = 0; break;
	        		case "Curitiba:Aracajú": distancia = 2595; break;
	        		case "Curitiba:Belém": distancia = 3193; break;
	        		case "Curitiba:Belo Horizonte": distancia = 1004; break;
	        		case "Curitiba:Boa Vista": distancia = 4821; break;
	        		case "Curitiba:Brasília": distancia = 1366; break;
	        		case "Curitiba:Campo Grande": distancia = 991; break;
	        		case "Curitiba:Cuiabá": distancia = 1679; break;
	        		case "Curitiba:Curitiba": distancia = 0; break;
	        		case "Florianópolis:Aracajú": distancia = 2892; break;
	        		case "Florianópolis:Belém": distancia = 3500; break;
	        		case "Florianópolis:Belo Horizonte": distancia = 1301; break;
	        		case "Florianópolis:Boa Vista": distancia = 5128; break;
	        		case "Florianópolis:Brasília": distancia = 1673; break;
	        		case "Florianópolis:Campo Grande": distancia = 1298; break;
	        		case "Florianópolis:Cuiabá": distancia = 1986; break;
	        		case "Florianópolis:Curitiba": distancia = 300; break;
	        		case "Florianópolis:Florianópolis": distancia = 0; break;
	        		case "Fortaleza:Aracajú": distancia = 1183; break;
	        		case "Fortaleza:Belém": distancia = 1610; break;
	        		case "Fortaleza:Belo Horizonte": distancia = 2528; break;
	        		case "Fortaleza:Boa Vista": distancia = 6548; break;
	        		case "Fortaleza:Brasília": distancia = 2200; break;
	        		case "Fortaleza:Campo Grande": distancia = 3407; break;
	        		case "Fortaleza:Cuiabá": distancia = 3406; break;
	        		case "Fortaleza:Curitiba": distancia = 3541; break;
	        		case "Fortaleza:Florianópolis": distancia = 3838; break;
	        		case "Fortaleza:Fortaleza": distancia = 0; break;
	        		case "Goiânia:Aracajú": distancia = 1848; break;
	        		case "Goiânia:Belém": distancia = 2017; break;
	        		case "Goiânia:Belo Horizonte": distancia = 906; break;
	        		case "Goiânia:Boa Vista": distancia = 4076; break;
	        		case "Goiânia:Brasília": distancia = 209; break;
	        		case "Goiânia:Campo Grande": distancia = 935; break;
	        		case "Goiânia:Cuiabá": distancia = 934; break;
	        		case "Goiânia:Curitiba": distancia = 1186; break;
	        		case "Goiânia:Florianópolis": distancia = 1493; break;
	        		case "Goiânia:Fortaleza": distancia = 2482; break;
	        		case "Goiânia:Goiânia": distancia = 0; break;
	        		case "João Pessoa:Aracajú": distancia = 611; break;
	        		case "João Pessoa:Belém": distancia = 2161; break;
	        		case "João Pessoa:Belo Horizonte": distancia = 2171; break;
	        		case "João Pessoa:Boa Vista": distancia = 6593; break;
	        		case "João Pessoa:Brasília": distancia = 2245; break;
	        		case "João Pessoa:Campo Grande": distancia = 3357; break;
	        		case "João Pessoa:Cuiabá": distancia = 3366; break;
	        		case "João Pessoa:Curitiba": distancia = 3188; break;
	        		case "João Pessoa:Florianópolis": distancia = 3485; break;
	        		case "João Pessoa:Fortaleza": distancia = 688; break;
	        		case "João Pessoa:Goiânia": distancia = 2442; break;
	        		case "João Pessoa:João Pessoa": distancia = 0; break;
	        		case "Porto Velho:Palmas": distancia = 2755; break;
	        		case "Maceió:Aracajú": distancia = 294; break;
	        		case "Maceió:Belém": distancia = 2173; break;
	        		case "Maceió:Belo Horizonte": distancia = 1854; break;
	        		case "Maceió:Boa Vista": distancia = 6279; break;
	        		case "Maceió:Brasília": distancia = 1930; break;
	        		case "Maceió:Campo Grande": distancia = 3040; break;
	        		case "Maceió:Cuiabá": distancia = 3049; break;
	        		case "Maceió:Curitiba": distancia = 2871; break;
	        		case "Maceió:Florianópolis": distancia = 3168; break;
	        		case "Maceió:Fortaleza": distancia = 1075; break;
	        		case "Maceió:Goiânia": distancia = 2125; break;
	        		case "Maceió:João Pessoa": distancia = 395; break;
	        		case "Manaus:Aracajú": distancia = 5215; break;
	        		case "Manaus:Belém": distancia = 5298; break;
	        		case "Manaus:Belo Horizonte": distancia = 3951; break;
	        		case "Manaus:Boa Vista": distancia = 785; break;
	        		case "Manaus:Brasília": distancia = 3490; break;
	        		case "Manaus:Campo Grande": distancia = 3051; break;
	        		case "Manaus:Cuiabá": distancia = 2357; break;
	        		case "Manaus:Curitiba": distancia = 4036; break;
	        		case "Manaus:Florianópolis": distancia = 4443; break;
	        		case "Manaus:Fortaleza": distancia = 5763; break;
	        		case "Manaus:Goiânia": distancia = 3291; break;
	        		case "Manaus:João Pessoa": distancia = 5808; break;
	        		case "Natal:Aracajú": distancia = 788; break;
	        		case "Natal:Belém": distancia = 2108; break;
	        		case "Natal:Belo Horizonte": distancia = 2348; break;
	        		case "Natal:Boa Vista": distancia = 6770; break;
	        		case "Natal:Brasília": distancia = 2422; break;
	        		case "Natal:Campo Grande": distancia = 3534; break;
	        		case "Natal:Cuiabá": distancia = 3543; break;
	        		case "Natal:Curitiba": distancia = 3365; break;
	        		case "Natal:Florianópolis": distancia = 3662; break;
	        		case "Natal:Fortaleza": distancia = 537; break;
	        		case "Natal:Goiânia": distancia = 2618; break;
	        		case "Natal:João Pessoa": distancia = 185; break;
	        		case "Palmas:Aracajú": distancia = 1662; break;
	        		case "Palmas:Belém": distancia = 1283; break;
	        		case "Palmas:Belo Horizonte": distancia = 1690; break;
	        		case "Palmas:Boa Vista": distancia = 4926; break;
	        		case "Palmas:Brasília": distancia = 973; break;
	        		case "Palmas:Campo Grande": distancia = 1785; break;
	        		case "Palmas:Cuiabá": distancia = 1784; break;
	        		case "Palmas:Curitiba": distancia = 2036; break;
	        		case "Palmas:Florianópolis": distancia = 2336; break;
	        		case "Palmas:Fortaleza": distancia = 2035; break;
	        		case "Palmas:Goiânia": distancia = 874; break;
	        		case "Palmas:João Pessoa": distancia = 2253; break;
	        		case "Porto Alegre:Aracajú": distancia = 3296; break;
	        		case "Porto Alegre:Belém": distancia = 3852; break;
	        		case "Porto Alegre:Belo Horizonte": distancia = 1712; break;
	        		case "Porto Alegre:Boa Vista": distancia = 5348; break;
	        		case "Porto Alegre:Brasília": distancia = 2027; break;
	        		case "Porto Alegre:Campo Grande": distancia = 1518; break;
	        		case "Porto Alegre:Cuiabá": distancia = 2206; break;
	        		case "Porto Alegre:Curitiba": distancia = 711; break;
	        		case "Porto Alegre:Florianópolis": distancia = 476; break;
	        		case "Porto Alegre:Fortaleza": distancia = 4242; break;
	        		case "Porto Alegre:Goiânia": distancia = 1847; break;
	        		case "Porto Alegre:João Pessoa": distancia = 3889; break;
	        		case "Porto Velho:Aracajú": distancia = 4230; break;
	        		case "Porto Velho:Belém": distancia = 4397; break;
	        		case "Porto Velho:Belo Horizonte": distancia = 3050; break;
	        		case "Porto Velho:Boa Vista": distancia = 1686; break;
	        		case "Porto Velho:Brasília": distancia = 2589; break;
	        		case "Porto Velho:Campo Grande": distancia = 2150; break;
	        		case "Porto Velho:Cuiabá": distancia = 1456; break;
	        		case "Porto Velho:Curitiba": distancia = 3135; break;
	        		case "Porto Velho:Florianópolis": distancia = 3442; break;
	        		case "Porto Velho:Fortaleza": distancia = 4862; break;
	        		case "Porto Velho:Goiânia": distancia = 2390; break;
	        		case "Porto Velho:João Pessoa": distancia = 4822; break;
	        		case "Recife:Aracajú": distancia = 501; break;
	        		case "Recife:Belém": distancia = 2074; break;
	        		case "Recife:Belo Horizonte": distancia = 2061; break;
	        		case "Recife:Boa Vista": distancia = 6483; break;
	        		case "Recife:Brasília": distancia = 2135; break;
	        		case "Recife:Campo Grande": distancia = 3247; break;
	        		case "Recife:Cuiabá": distancia = 3255; break;
	        		case "Recife:Curitiba": distancia = 3078; break;
	        		case "Recife:Florianópolis": distancia = 3375; break;
	        		case "Recife:Fortaleza": distancia = 800; break;
	        		case "Recife:Goiânia": distancia = 2332; break;
	        		case "Recife:João Pessoa": distancia = 120; break;
	        		case "Rio Branco:Aracajú": distancia = 4763; break;
	        		case "Rio Branco:Belém": distancia = 4931; break;
	        		case "Rio Branco:Belo Horizonte": distancia = 3584; break;
	        		case "Rio Branco:Boa Vista": distancia = 2230; break;
	        		case "Rio Branco:Brasília": distancia = 3123; break;
	        		case "Rio Branco:Campo Grande": distancia = 2684; break;
	        		case "Rio Branco:Cuiabá": distancia = 1990; break;
	        		case "Rio Branco:Curitiba": distancia = 3669; break;
	        		case "Rio Branco:Florianópolis": distancia = 3976; break;
	        		case "Rio Branco:Fortaleza": distancia = 5396; break;
	        		case "Rio Branco:Goiânia": distancia = 2924; break;
	        		case "Rio Branco:João Pessoa": distancia = 5356; break;
	        		case "Rio de Janeiro:Aracajú": distancia = 1855; break;
	        		case "Rio de Janeiro:Belém": distancia = 3250; break;
	        		case "Rio de Janeiro:Belo Horizonte": distancia = 434; break;
	        		case "Rio de Janeiro:Boa Vista": distancia = 5159; break;
	        		case "Rio de Janeiro:Brasília": distancia = 1148; break;
	        		case "Rio de Janeiro:Campo Grande": distancia = 1444; break;
	        		case "Rio de Janeiro:Cuiabá": distancia = 2017; break;
	        		case "Rio de Janeiro:Curitiba": distancia = 852; break;
	        		case "Rio de Janeiro:Florianópolis": distancia = 1144; break;
	        		case "Rio de Janeiro:Fortaleza": distancia = 2805; break;
	        		case "Rio de Janeiro:Goiânia": distancia = 1338; break;
	        		case "Rio de Janeiro:João Pessoa": distancia = 2448; break;
	        		case "Salvador:Aracajú": distancia = 356; break;
	        		case "Salvador:Belém": distancia = 2100; break;
	        		case "Salvador:Belo Horizonte": distancia = 1372; break;
	        		case "Salvador:Boa Vista": distancia = 5794; break;
	        		case "Salvador:Brasília": distancia = 1446; break;
	        		case "Salvador:Campo Grande": distancia = 2568; break;
	        		case "Salvador:Cuiabá": distancia = 2566; break;
	        		case "Salvador:Curitiba": distancia = 2385; break;
	        		case "Salvador:Florianópolis": distancia = 2682; break;
	        		case "Salvador:Fortaleza": distancia = 1389; break;
	        		case "Salvador:Goiânia": distancia = 1643; break;
	        		case "Salvador:João Pessoa": distancia = 949; break;
	        		case "São Luis:Aracajú": distancia = 1578; break;
	        		case "São Luis:Belém": distancia = 806; break;
	        		case "São Luis:Belo Horizonte": distancia = 2738; break;
	        		case "São Luis:Boa Vista": distancia = 6120; break;
	        		case "São Luis:Brasília": distancia = 2157; break;
	        		case "São Luis:Campo Grande": distancia = 2979; break;
	        		case "São Luis:Cuiabá": distancia = 2978; break;
	        		case "São Luis:Curitiba": distancia = 3230; break;
	        		case "São Luis:Florianópolis": distancia = 3537; break;
	        		case "São Luis:Fortaleza": distancia = 1070; break;
	        		case "São Luis:Goiânia": distancia = 2054; break;
	        		case "São Luis:João Pessoa": distancia = 1660; break;
	        		case "São Paulo:Aracajú": distancia = 2187; break;
	        		case "São Paulo:Belém": distancia = 2933; break;
	        		case "São Paulo:Belo Horizonte": distancia = 586; break;
	        		case "São Paulo:Boa Vista": distancia = 4756; break;
	        		case "São Paulo:Brasília": distancia = 015; break;
	        		case "São Paulo:Campo Grande": distancia = 1014; break;
	        		case "São Paulo:Cuiabá": distancia = 1614; break;
	        		case "São Paulo:Curitiba": distancia = 408; break;
	        		case "São Paulo:Florianópolis": distancia = 705; break;
	        		case "São Paulo:Fortaleza": distancia = 3127; break;
	        		case "São Paulo:Goiânia": distancia = 926; break;
	        		case "São Paulo:João Pessoa": distancia = 2770; break;
	        		case "Teresina:Aracajú": distancia = 1142; break;
	        		case "Teresina:Belém": distancia = 947; break;
	        		case "Teresina:Belo Horizonte": distancia = 2302; break;
	        		case "Teresina:Boa Vista": distancia = 6052; break;
	        		case "Teresina:Brasília": distancia = 1789; break;
	        		case "Teresina:Campo Grande": distancia = 2911; break;
	        		case "Teresina:Cuiabá": distancia = 2910; break;
	        		case "Teresina:Curitiba": distancia = 3143; break;
	        		case "Teresina:Florianópolis": distancia = 3450; break;
	        		case "Teresina:Fortaleza": distancia = 634; break;
	        		case "Teresina:Goiânia": distancia = 1986; break;
	        		case "Teresina:João Pessoa": distancia = 1224; break;
	        		case "Vitória:Aracajú": distancia = 1408; break;
	        		case "Vitória:Belém": distancia = 3108; break;
	        		case "Vitória:Belo Horizonte": distancia = 524; break;
	        		case "Vitória:Boa Vista": distancia = 5261; break;
	        		case "Vitória:Brasília": distancia = 1239; break;
	        		case "Vitória:Campo Grande": distancia = 1892; break;
	        		case "Vitória:Cuiabá": distancia = 2119; break;
	        		case "Vitória:Curitiba": distancia = 1300; break;
	        		case "Vitória:Florianópolis": distancia = 1597; break;
	        		case "Vitória:Fortaleza": distancia = 2397; break;
	        		case "Vitória:Goiânia": distancia = 1428; break;
	        		case "Vitória:João Pessoa": distancia = 2001; break;
	        		case "Maceió:Maceió": distancia = 0; break;
	        		case "Manaus:Maceió": distancia = 5491; break;
	        		case "Manaus:Manaus": distancia = 0; break;
	        		case "Natal:Maceió": distancia = 572; break;
	        		case "Natal:Manaus": distancia = 5985; break;
	        		case "Natal:Natal": distancia = 0; break;
	        		case "Palmas:Maceió": distancia = 1851; break;
	        		case "Palmas:Manaus": distancia = 4141; break;
	        		case "Palmas:Natal": distancia = 2345; break;
	        		case "Palmas:Palmas": distancia = 0; break;
	        		case "Porto Alegre:Maceió": distancia = 3572; break;
	        		case "Porto Alegre:Manaus": distancia = 4563; break;
	        		case "Porto Alegre:Natal": distancia = 4066; break;
	        		case "Porto Alegre:Palmas": distancia = 2747; break;
	        		case "Porto Alegre:Porto Alegre": distancia = 0; break;
	        		case "Porto Velho:Maceió": distancia = 4505; break;
	        		case "Porto Velho:Manaus": distancia = 901; break;
	        		case "Porto Velho:Natal": distancia = 4998; break;
	        		case "Porto Velho:Porto Alegre": distancia = 3662; break;
	        		case "Porto Velho:Porto Velho": distancia = 0; break;
	        		case "Recife:Maceió": distancia = 285; break;
	        		case "Recife:Manaus": distancia = 5698; break;
	        		case "Recife:Natal": distancia = 297; break;
	        		case "Recife:Palmas": distancia = 2058; break;
	        		case "Recife:Porto Alegre": distancia = 3779; break;
	        		case "Recife:Porto Velho": distancia = 4712; break;
	        		case "Recife:Recife": distancia = 0; break;
	        		case "Rio Branco:Maceió": distancia = 5039; break;
	        		case "Rio Branco:Manaus": distancia = 1445; break;
	        		case "Rio Branco:Natal": distancia = 5533; break;
	        		case "Rio Branco:Palmas": distancia = 3764; break;
	        		case "Rio Branco:Porto Alegre": distancia = 4196; break;
	        		case "Rio Branco:Porto Velho": distancia = 544; break;
	        		case "Rio Branco:Recife": distancia = 5243; break;
	        		case "Rio Branco:Rio Branco": distancia = 0; break;
	        		case "Rio de Janeiro:Maceió": distancia = 2131; break;
	        		case "Rio de Janeiro:Manaus": distancia = 4374; break;
	        		case "Rio de Janeiro:Natal": distancia = 2625; break;
	        		case "Rio de Janeiro:Palmas": distancia = 2124; break;
	        		case "Rio de Janeiro:Porto Alegre": distancia = 1553; break;
	        		case "Rio de Janeiro:Porto Velho": distancia = 3473; break;
	        		case "Rio de Janeiro:Recife": distancia = 2338; break;
	        		case "Rio de Janeiro:Rio Branco": distancia = 4007; break;
	        		case "Rio de Janeiro:Rio de Janeiro": distancia = 0; break;
	        		case "Salvador:Maceió": distancia = 632; break;
	        		case "Salvador:Manaus": distancia = 5009; break;
	        		case "Salvador:Natal": distancia = 1126; break;
	        		case "Salvador:Palmas": distancia = 1454; break;
	        		case "Salvador:Porto Alegre": distancia = 3090; break;
	        		case "Salvador:Porto Velho": distancia = 4023; break;
	        		case "Salvador:Recife": distancia = 839; break;
	        		case "Salvador:Rio Branco": distancia = 4457; break;
	        		case "Salvador:Rio de Janeiro": distancia = 1649; break;
	        		case "Salvador:Salvador": distancia = 0; break;
	        		case "São Luis:Maceió": distancia = 1672; break;
	        		case "São Luis:Manaus": distancia = 5335; break;
	        		case "São Luis:Natal": distancia = 1607; break;
	        		case "São Luis:Palmas": distancia = 1386; break;
	        		case "São Luis:Porto Alegre": distancia = 3891; break;
	        		case "São Luis:Porto Velho": distancia = 4434; break;
	        		case "São Luis:Recife": distancia = 1573; break;
	        		case "São Luis:Rio Branco": distancia = 4968; break;
	        		case "São Luis:Rio de Janeiro": distancia = 3015; break;
	        		case "São Luis:Salvador": distancia = 1599; break;
	        		case "São Luis:São Luis": distancia = 0; break;
	        		case "São Paulo:Maceió": distancia = 2453; break;
	        		case "São Paulo:Manaus": distancia = 3971; break;
	        		case "São Paulo:Natal": distancia = 2947; break;
	        		case "São Paulo:Palmas": distancia = 1776; break;
	        		case "São Paulo:Porto Alegre": distancia = 1109; break;
	        		case "São Paulo:Porto Velho": distancia = 3070; break;
	        		case "São Paulo:Recife": distancia = 2660; break;
	        		case "São Paulo:Rio Branco": distancia = 3604; break;
	        		case "São Paulo:Rio de Janeiro": distancia = 429; break;
	        		case "São Paulo:Salvador": distancia = 1962; break;
	        		case "São Paulo:São Luis": distancia = 2970; break;
	        		case "São Paulo:São Paulo": distancia = 0; break;
	        		case "Teresina:Maceió": distancia = 1236; break;
	        		case "Teresina:Manaus": distancia = 5267; break;
	        		case "Teresina:Natal": distancia = 1171; break;
	        		case "Teresina:Palmas": distancia = 1401; break;
	        		case "Teresina:Porto Alegre": distancia = 3804; break;
	        		case "Teresina:Porto Velho": distancia = 4366; break;
	        		case "Teresina:Recife": distancia = 1137; break;
	        		case "Teresina:Rio Branco": distancia = 4900; break;
	        		case "Teresina:Rio de Janeiro": distancia = 2579; break;
	        		case "Teresina:Salvador": distancia = 1163; break;
	        		case "Teresina:São Luis": distancia = 446; break;
	        		case "Teresina:São Paulo": distancia = 2792; break;
	        		case "Teresina:Teresina": distancia = 0; break;
	        		case "Vitória:Maceió": distancia = 1684; break;
	        		case "Vitória:Manaus": distancia = 4476; break;
	        		case "Vitória:Natal": distancia = 2178; break;
	        		case "Vitória:Palmas": distancia = 2214; break;
	        		case "Vitória:Porto Alegre": distancia = 2001; break;
	        		case "Vitória:Porto Velho": distancia = 3575; break;
	        		case "Vitória:Recife": distancia = 1831; break;
	        		case "Vitória:Rio Branco": distancia = 4109; break;
	        		case "Vitória:Rio de Janeiro": distancia = 521; break;
	        		case "Vitória:Salvador": distancia = 1202; break;
	        		case "Vitória:São Luis": distancia = 2607; break;
	        		case "Vitória:São Paulo": distancia = 882; break;
	        		case "Vitória:Teresina": distancia = 2171; break;
	        		case "Vitória:Vitória": distancia = 0; break;
	        		default : distancia = -1; break;
	        	}
	        	
	        	if (distancia != -1)
	        		grafoEstados.adicionarAresta(new Aresta(verticeEstados[l].getNome() + ":" + verticeEstados[c].getNome(), verticeEstados[l] , verticeEstados[c], distancia));
        	}
    	}
    	
    	grafoEstados.verificaAdjacencias();
    	
    	grafoEstados.printaMatrizAdjacencias();
    	grafoEstados.printaMatrizIncidencia();
    	
        System.out.println(grafoEstados);

    }
}