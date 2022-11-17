# programmazioneMobile2k21-kotlin
Realizzazione di una applicazione android, sviluppata in kotlin, per la gestione della dispensa

# Introduzione

EasyCooking è un'applicazione che consente a chiunque di cucinare con semplicità: grazie alla
nostra app potrai cercare ricette, crearne di tue, gestire la tua dispensa e la tua lista della spesa!
Make it easier, use EasyCooking!

## Analisi degli obiettivi

L'obiettivo di EasyCooking è quello di poter cucinare con maggiore semplicità, accendendo alle
molteplici ricette presenti nel nostro database senza dover ogni volta navigare tra i molteplici
siti web.
Per poter accedere alle nostre ricette sarà suffciente una connessione internet, è possibile effettuare
una ricerca a seconda del nome, della categoria e dell'origine della ricetta stessa, inoltre è
possibile condividere la ricetta nei social presenti all'interno del dispositivo.
Con EasyCooking è inoltre possibile creare proprie ricette, che verranno conservate in maniera
persistente, così da potervi accedere anche quando la rete internet non è disponibile: questa funzionalit
à risulta, però, disponibile solo se l'utente si registra.
Se l'utente non ha idea o voglia di scegliere una particolare ricetta, la funzionalità Ispirami
genererà una ricetta casuale dal nostro database che verrà mostrata a video.
Spesso la dispobilità di ingredienti risulta essere limitata: con EasyCooking è possibile inserire
gli elementi presenti nella propria dispensa per poi effettuare una ricerca delle ricette sugli stessi,
in questo modo sarà più facile cucinare qualcosa attraverso gli ingredienti che si possiedono già.
Infine, se l'utente desidera cucinare un piatto, ma allo stesso tempo non ha a disposizione tutti
gli elementi necessari, potrà scrivere nella lista della spesa gli elementi mancanti, così da non
dimenticare di doverli acquistare.

## Sintesi dell'approccio

L'approccio utilizzato è quello misto: abbiamo definito inizialmente le componenti principali che
avrebbero costituito la nostra applicazioni e secondo l'approccio top down, abbiamo diviso ogni
componente in sottoproblemi: per ognuna di esse abbiamo creato il layout e la logica che avrebbe
poi implementato la singola pagina.
A seguire abbiamo adottato il bottom up, per poter unificare ogni schermata secondo una certa
logica: ecco che ogni componente fondamentale è legato dalla schermata principale dai navigator,
che consentono di spostarsi con facilità tra le varie pagine.
Per la realizzazione dell'applicazione abbiamo usufruito della documentazione android e flut-
ter :
 - la prima ci ha permesso di sviluppare le componenti grafiche con una logica adeguata,
permettendone un utilizzo efficace;
 - la seconda ci ha permesso di gestire i dati da mostrare e la sezione di registrazione in
maniera ottimale.

# Sviluppo Android

## Analisi dei requisiti

### Requisiti Funzionali

Dopo aver dato una breve introduzione alle funzionalità della nostra applicazione, passiamo ora
all'analisi funzionale nel dettaglio.
Partiamo descrivendo la pagina iniziale: Accesso: l'applicazione si apre con la schermata di
accesso. La casistica si riduce a cinque possibilità:
 - L'utente ha un account: se l'utente è già registrato, sarà sufficiente inserire username e
password e cliccare su accedi, per poter accedere all'effettiva applicazione completa di
tutte le funzionalità.
 - L'utente ha un account google: se l'utente possiede un account google sarà possibile effettuare
l'accesso inserendo i dati che google richiederà.
 - L'utente ha un account ma non ricorda la password: in questo caso è possibile resettare la
password cliccando sopra l'apposita scritta, ed una volta inserita l'email verrà inviata una
mail con la nuova password.
 - L'utente non ha un account: in questo caso sarà possibile effettuare la registrazione inserendo
i dati richiesti dalla form.
 - L'utente non ha un account e non desidera effettuare la registrazione: cliccando sopra 'con-
tinua senza registrarti', l'utente avrà accesso all'applicazione sprovvista della possibilità di
inserire le proprie ricette.
A questo punto avremo quindi una distinzione netta tra chi risulta essere a tutti gli effetti
autenticato e chi invece non lo è.
Le due tipologie differiscono sostanzialmente per una funzionalità, dunque con questa premessa
andremo direttamente a descrivere tutte le altre, che compariranno dopo la schermata di accesso:
 - Cerca Ricette: è la prima schermata che appare in entrambe le casistiche e permette di
effettuare una ricerca delle ricette presenti all'interno del database.
Abbiamo tre filtri a disposizione:
   - Nome ricetta: consente di effettuare la ricerca secondo il nome della ricetta, in maniera
case-insensitive.
   - Categoria: possiamo selezionare una categoria tra le presenti ed effettuare la ricerca
su di essa.
   - Origine: analoga alla precedente ma con il paese di origine della ricetta.
La ricerca può essere effettuata non applicando oppure applicando uno o tutti i filtri appena
descritti: le ricette verranno riportate all'interno di una Recycler View.
 - Ricetta nel Dettaglio( del Cerca Ricetta): la visualizzazione può essere effettuata a
partire dalla lista che verrà dalla selezione precedente: premendo sopra uno degli item
riportati nella Recycler View, si aprirà la ricetta mostrandone tutte le caratteristiche nel
dettaglio.
In alto a destra un pulsante consente la condivisione della ricetta, sfruttando una delle
applicazioni già installate all'interno del dispositivo.
 - Dispensa: nella dispensa è possibile registrare gli ingredienti che l'utente effettivamente
possiede.
Per aggiungere un elemento sarà sufficiente cliccare sul pulsante 'Aggiungi' : si aprirà un
dialog nel quale inserire l'ingrediente. La lista di tutti gli ingredienti viene visualizzata in
una Recycler view, dalla quale è inoltre possibile eliminare un qualunque elemento semplicemente
facendolo scorrere da destra a sinistra.
È possibile effettuare una ricerca delle ricette presenti nel database: dopo aver inserito un
alimento nella dispensa, cliccando su 'Cerca', verranno filtrate tutte le ricette che lo contengono
(la ricerca viene effettuata filtrando tutti gli ingredienti presenti in dispensa).
Infine, una volta che tutte le ricette verranno mostrate, al tocco di una qualunquedi esse
verrà effettuato un controllo: se non tutti gli ingredienti sono presenti all'interno della dispensa,
verrà richiesto all'utente se vuole andare ad aggiungere gli elementi all'interno della
lista della spesa.
 - Le tue Ricette: questa funzionalità è disponibile solamente se l'utente si è registrato ed
ha effettuato l'accesso, e consente di registrare la propria ricetta in maniera permanente.
Cliccando sopra 'Aggiungi la tua ricetta' si aprirà un dialog per l'inserimento dei dati della
ricetta.
Nel momento in cui l'utente che sta inserendo la ricetta, cliccherà sopra il bottone per
aggiungere l'immagine, potrà scegliere se inserirla accedendo alla fotocamera oppure prendendola
dalla galleria. In entrambi i casi l'utente deciderà se concedere o meno l'accesso
alle due risorse accettando i corrispettivi consensi.
Dopo aver consentito o negato i due permessi, l'utente potrà andare a completare la form,
inserendo Nome, Porzioni, Immagine (premendo sopra l'immagine preimpostata), Tempo
di Preparazione, Tempo di Cottura, Ingredienti (gli ingredienti devono essere inseriti uno
alla volta, premendo sopra 'Aggiungi' ad ogni nuovo elemento), Preparazione.
Completata la form sarà sufficiente premere sopra 'Salva Ricetta' per memorizzarla.
Salvata la ricetta, verremo ricondotti alla schermata precedente nella quale troveremo
l'elemento inserito (gestito anche in questo caso con una Recycler View) completo di nome
ed immagine (se inserita).
 - Ricetta nel Dettaglio( de Le tue Ricette): la visualizzazione nel dettaglio della ricetta
creata può essere fatta premendo sopra l'elemento presente nella pagina e sarà completo
delle informazioni inserite nella form precedente.
 - Lista della Spesa: nella lista della spesa è possibile inserire tutti gli ingredienti che necessitano
all'utente per poter realizzare l'effettiva ricetta: premendo sopra 'Compra' si aprirà
un dialog nel quale inserire il nome dell'ingrediente, che verrà salvato una volta premuto
sopra 'Aggiungi alla Lista'. Una volta inseriti gli ingredienti, questi verranno visualizzati in
una Recycler View, dalla quale è possibile eliminare gli elementi singolarmente, facendoli
scorrere da destra a sinistra.

### Requisiti non Funzionali

Abbiamo deciso di evidenziare, fra i requisiti non funzionali, tutte le funzionalità legate all'utilizzo
di Firebase, in particolar modo:
 - Database: il database è stato implementato manualmente in json.
Le ricette sono state prese online da siti quali Giallo Zafferano e Cucchiaio D'argento,
oppure da ricette personali.
Il file è stato successivamente caricato nel Realtime Database di Firebase, al quale ci siamo
appoggiati per ottenere e filtrare le ricette.
Seguendo la documentazione in Firebase abbiamo implementato una funzione che ci ha
consentito di sfruttare un'istanza da cui attingere ai dati: in questo modo abbiamo alleggerito
l'appicazione delle dimensioni delle ricette formato json (comprensive delle immagini
salvate nello storage).
 - Autenticazione: anche per quanto riguarda l'autenticazione abbiamo deciso di appoggiarci
a Firebase, ed in particolar modo abbiamo sfrutta le funzionalità di Auth, per
l'autenticazione con email e password in maniera anonima ed anche per l'autenticazione
con un account google.
Anche in questo caso seguendo la documentazione, abbiamo sfruttato le dipendenze a disposizione
per registrare gli account che effettuano la registrazione, che sia in maniera anonima
oppure con google.

## Architettura

### Classi Kotlin, Activity, Fragment
L'applicazione sfrutta activity e fragment secondo un'architettura modulare: abbiamo deciso di
raggruppare in quattro macro categorie il progetto complessivo:
 - Auth: comprensiva delle activity per la registrazione e la modifica della password;
 - Memory: suddivisa in cinque sotto-cartelle:
 - DB: comprensivo dell'effettivo database, cui sono legate le altre room;
Le rimanenti cartelle seguono una logica comune(eccezion fatta per la cartella ricetta):
poichè in ognuna delle viste principali è presente una RecyclerView, legata ad un'Adapter
ed una Room per la persistenza dei dati che devono essere memorizzati (e quindi un Dao,
una Entity, una Repository ed un ViewModel ) :
   - Dispensa: comprende in aggiunta l'activity per lanciare il dialog che ci consentirà di
inserire un nuovo elemento nella dispensa;
RicettaTua: comprende in aggiunta l'activity per lanciare il dialog che ci consentirà
di inserire una ricetta definita dall'utente; inoltre sono state definite le due classi kotlin
per la gestione dei permessi della fotocamera e della galleria del telefono cellulare;
   - Spesa: comprende in aggiunta l'activity per lanciare il dialog che ci consentirà di
inserire un nuovo elemento nella lista della spesa;
   - Ricetta: la cartella ricetta risulta diversa dalle precedenti, in quanto la gestione dei
dati non avviene in maniera permanente ma tramite l'utilizzo di Firebase: troviamo al
suo interno solo il model della ricetta, l'adapter e l'activity del dettaglio della ricetta
che verrà poi visualizzata.
 - View: la cartella views è comprensiva viste presenti nell'applicazione, siano esse fragment
oppure activity:
   - Base: activity di appoggio per i fragment che veranno visualizzati se l'utente è registrato;
   - Base_nonReg: activity di appoggio per i fragment che veranno visualizzati se l'utente
non è registrato;
   - Contattaci: fragment in cui vengono gestiti i nostri contatti, con due riferimenti instagram
e la possibilità di inviarci una mail;
   - Dispensa: fragment per la gestione degli elementi nella dispensa;
   - Informations: fragment contente le informazioni riguardanti l'utilizzo dell'applicazione;
   - Ispirami: fragment in cui viene generata una ricetta casuale estratta dal database;
   - Lista Spesa: fragment per la gestione degli elementi nella lista della spesa;
   - RicettaCerca: fragment per la visualizzazione ed il filtraggio delle ricette presenti nel
database;
   - RicetteTue: fragment per la gestione delle ricette create dall'utente;
 - Utils: comprende la funzione che consente l'eliminazione di un item, facendolo scorrere da
destra verso sinistra, e la decorazione utilizzata per gli item all'interno della Recycler View.
2.2.2 Resources
Anche per quanto riguarda l'organizzazione delle resources dell'applicazione abbiamo distinto in:
 - Drawable: in cui abbiamo inserito tutte le immagini utili per i nostri layout;
 - Font: font di scrittura utilizzati anch'essi per i layout;
 - Layout: gli effettivi layout che abbiamo sviluppato per la grafica mobile.
Abbiamo qui aggiunto oltre al normale layout, anche il suo corrispettivo landscape per
rendere l'applicazione maggiormente responsive;
 - Menu: contiene tutti i menù utilizzati nell'applicazione differenziati per tipologia di utente,
tra cui:
   - Bottom Menu: per scorrere tra i main fragment (Dispensa, Cerca Ricetta, Ricette Tue,
Lista Spesa);
   - Navigation Drawer: per le funzionalità aggiuntive (Ispirami, Contattaci, Logout per
l'utente registrato);
   - Option Menu: per la gestione della parte informativa;
 - MipMap: abbiamo inserito l'icona della nostra applicazione, la quale sarà visibile quando
la chiuderemo;
 - Navigation: per la gestione della navigazione tra i fragment;
 - Values: colori, font, stili e stringhe utili per arricchire i nostri layout.

## UI

Riportiamo di seguito il diagramma dei casi d'uso e le schermate che verranno visualizzate durante
l'utilizzazione dell'applicazione, comprendenti le operazioni che possono essere svolte.

### Diagramma dei casi d'uso

<p align="center">
<img src="https://github.com/MargheritaGaleazzi/programmazioneMobile2k21-kotlin/blob/main/imm/1.jpg">
</p>

### Login

<p align="center">
<img src="https://github.com/MargheritaGaleazzi/programmazioneMobile2k21-kotlin/blob/main/imm/2.jpg">
</p>
<p align="center">
<img src="https://github.com/MargheritaGaleazzi/programmazioneMobile2k21-kotlin/blob/main/imm/3.jpg">
</p>

### Cerca Ricette

<p align="center">
<img src="https://github.com/MargheritaGaleazzi/programmazioneMobile2k21-kotlin/blob/main/imm/4.jpg">
</p>
<p align="center">
<img src="https://github.com/MargheritaGaleazzi/programmazioneMobile2k21-kotlin/blob/main/imm/5.jpg">
</p>

### Dispensa

<p align="center">
<img src="https://github.com/MargheritaGaleazzi/programmazioneMobile2k21-kotlin/blob/main/imm/6.jpg">
</p>
<p align="center">
<img src="https://github.com/MargheritaGaleazzi/programmazioneMobile2k21-kotlin/blob/main/imm/7.jpg">
</p>

### Tue Ricette

<p align="center">
<img src="https://github.com/MargheritaGaleazzi/programmazioneMobile2k21-kotlin/blob/main/imm/8.jpg">
</p>
<p align="center">
<img src="https://github.com/MargheritaGaleazzi/programmazioneMobile2k21-kotlin/blob/main/imm/9.jpg">
</p>

### Lista Spesa

<p align="center">
<img src="https://github.com/MargheritaGaleazzi/programmazioneMobile2k21-kotlin/blob/main/imm/10.jpg">
</p>

### Login interno

<p align="center">
<img src="https://github.com/MargheritaGaleazzi/programmazioneMobile2k21-kotlin/blob/main/imm/11.jpg">
</p>

### Ispirami

<p align="center">
<img src="https://github.com/MargheritaGaleazzi/programmazioneMobile2k21-kotlin/blob/main/imm/12.jpg">
</p>

### Contattaci

<p align="center">
<img src="https://github.com/MargheritaGaleazzi/programmazioneMobile2k21-kotlin/blob/main/imm/13.jpg">
</p>

### Logout

<p align="center">
<img src="https://github.com/MargheritaGaleazzi/programmazioneMobile2k21-kotlin/blob/main/imm/14.jpg">
</p>

### Informazioni

<p align="center">
<img src="https://github.com/MargheritaGaleazzi/programmazioneMobile2k21-kotlin/blob/main/imm/15.jpg">
</p>

### Navigation Drawer
<p align="center">
<img src="https://github.com/MargheritaGaleazzi/programmazioneMobile2k21-kotlin/blob/main/imm/16.jpg">
</p>

## Sviluppo

In questa sezione descriveremo brevemente glie aspetti più interessanti dello sviluppo della nostra
applicazione:
 - Persistenza dei dati: la persistenza dei dati è stata gestita mediante la libreria room per
poter mantenere gli elementi di maggiore interesse dei nostri fragment i quali a causa del
lifecycle sarebbero stati invece eliminati al termine della loro vita.
   - Con le classi Entity abbiamo definito le effettive entità complete di chiave primaria e
degli attributi di interesse,
   - nel DAO abbiamo definito le funzioni che ci hanno permesso di estrarre/eliminare/inserire
dati all'interno del database;
   - la Repository ci consente di accedere agli effettivi dati del database locale,
   - infine con il viewmodel siamo andati a gestire gli stessi dati per l'interfaccia grafica.
 - RecyclerView: ogni recyclerview presente nel nostro progetto è stata pensata con lo scopo
di mostrare tutti glie elementi laddove erano presenti in quantità non indifferente.
Ognuna di esse è stata gestita tramite un Adapter, attraverso il quale siamo andati ad inserire
gli elementi che se presenti sarebbero stati mostrati (siano essi stati presi da Firebase
oppure dal database locale).
Per gli elementi riguardanti le ricette, questi sono stati pensati come delle card (dimensionate
nell'apposita classe), nei quali è stato inserito il nome e l'immagine, quest'ultima
gestita tramite la libreria Glide; mentre nella dispensa e nella lista della spesa vengono
mostrati come semplici riquadri.
 - Condivisione: L'applicazione consente di condividere una ricetta di interesse attraverso
il pulsante in alto a destra.
È stato creato come un intent che ci consentirà di inviare un piccolo contenuto testuale ed
un invito ad utilizzare la nostra apliccazione;
 - Permessi: I permessi per l'accesso alla fotocamera ed alla galleria ci hanno messo a dura
prova, ma siamo riusciti a risolvere ogni inconveniente: abbiamo optato per la differenziazione
delle schermate quando il permesso veniva accettato e quando invece veniva negato:
in questo modo anche senza l'autorizzazione della fotocamera e della galleria sarà possibile
inserire una nuova ricetta, che verrà mostrata nella recycler view (e poi successivamente
nel dettaglio della ricetta) con un immagine di default.
 - Firebase: Firebase ci ha consentito di gestire dati ed autenticazione con semplicità.
Una volta inserite le dipendenze abbiamo potuto sfruttare le funzioni messe a disposizioni
da Firebase stesso: per l'autenticazione con email e password abbiamo sfruttato un'istanza
che ci ha consentito di andare a verificare se le effettive credenziali fossero presenti, permettendo
l'accesso nel caso di esito positivo o negandolo altrimenti.
L'accesso con Google è stato gestito mediante il GoogleSignIn, il quale lanciando un intent
gestisce in maniera autonoma l'autenticazione.

## Testing

L'applicazione è stata sottoposta a diversi test, superati con successo:
 - verifica che il campo email sia vuoto.
 - verifica che i campi della form di registrazione siano validi.
 - verifica che la mail inserita esista.
 - verifica che il campo password non sia vuoto.
 - verifica che la password abbia un numero di caratteri superiori a sei.

## Autori
 - Margherita Galeazzi -> https://github.com/MargheritaGaleazzi
 - Lorenzo Longarini -> https://github.com/LorenzoLongarini
 - Chiara Amalia Caporusso -> https://github.com/ChiaraAmalia
