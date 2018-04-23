# MongoDB_Objects and Spring
Oggetti,Dao,MongoDB,Connessioni a Spring.

Questa repository ha come ruolo il riuscire ad estrarre i documenti (dati) presenti nel nostro Database MongoDB ed il ruiscire a convertirli in oggetti sui quali poter operare attraverso Java e caricarli su una pagina web.

La directory MongoDB_Objects contiene: La cartella Oggetti contiene la struttura basilare degli oggetti su cui lavoreremo. La cartella Dao sono i Data Access Obects e sono delle interfacce che sono implementate nelle classi della cartella Connessioni. La cartella Connessioni contiene in primis la classe ConnectionMongoDB, che attraverso l'URL si connette al Database Mongo presente in remoto; in seguito, usiamo i Dao per creare i Mongo Objects, che avranno i metodi necessari alla manipolazione ed utilizzo dei dati.

La directory Spring contiene: La cartella Controller, che a sua volta ha i tre controller relativi ai tre oggetti e le tre collezioni del database con cui opereremo. Ciascun controller ha una serie di metodi che permettono la creazione di un vero e proprio servizio Restful. Infatti, stiamo sfruttando un WebService di tipo Restful attraverso Spring per poter rendere disponibili le risorse del nostro MongoDatabase sottoforma di Json in una determinata pagina web, hostata in localhost:8080 attraverso Tomcat.

Per poter accedere ai Json, creeremo un server che gestirà le pagine HTML ed effettuerà le opportune chiamate Put,Get e Post per poter ottenere le risorse di cui le nostre pagine web avranno bisogno.
