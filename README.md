# Rastreio de Encomendas do Correio *Done*

Esse projeto FullStack Angular + Spring Boot  trata-se de uma aplicação que rastreia objetos postados no correios.

![enter image description here](https://uploaddeimagens.com.br/images/004/250/499/original/screen.jpg?1670208514)


## Servidor de desenvolvimento

Execute  a classe ***TrackcorreiosApplication*** .

**Obs**: O rastreio só ira funcionar informando o objeto: CR123456789BR. Para que retorne o rastreio de qualquer objeto você deve socilitar as credenciais de acesso da API. No link a seguir você consulta como solicitar as credenciais de acesso e como utiliza-lá -- > https://github.com/chipytux/correiosApi

![enter image description here](https://uploaddeimagens.com.br/images/004/250/521/original/ECLIP.jpg?1670209529)

Essa aplicação consome a API Link e Track. Caso queira utilizar desse serviço para consumir a API, na pasta service --> TrackService.class você pode inserir nas variáveis user e token as credencias que você receber. Pronto, você já irá consumir a API.

Demonstração no YouTube: https://youtu.be/lGpmDOgg9BA

## Agradecimentos

Link e Track pela disponibilização da API https://linketrack.com/api?utm_source=footer

