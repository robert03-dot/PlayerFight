//[P1] Concepte OOP - exerciții
//        Clasa 'Player Status'
//        Cerință
//        Realizează design-ul și implementarea unei clase PlayerStatus care menține actualizată starea unui Player în cadrul jocului.
//
//        Clasa trebuie să respecte principiile OOP învățate până la acest moment. De exemplu, ține cont de: vizibilitatea stării obiectelor,
//        separarea corectă a conceptelor, modularitatea codului, refolosirea funcționalității, ascunderea detaliilor etc. Cu alte cuvinte,
//        punctarea exercițiului se va realiza ținând cont atât de funcționalitate cât și de arhitectura clasei.
//        Starea internă
//        Starea internă a obiectelor de tip PlayerStatus va conține:
//
//        nickname: un șir de caractere, ce semnifică numele jucătorului.
//        score: un număr întreg, ce reprezintă scorul jucătorului.
//        lives: un număr întreg, ce simbolizează numărul de vieți al jucătorului.
//        health: un număr întreg, între 0 și 100, ce reprezintă procentul de viață rămas.
//        weaponInHand: un șir de caractere ce simbolizează arma jucătorului.
//        positionX: coordonata OX a poziției jucătorului, o valoare numerică reală.
//        positionY: coordonata OY a poziției jucătorului, o valoare numerică reală.
//        gameName: numele jocului.
//        toți jucătorii fac parte din același joc. Prin urmare, valoarea câmpului va fi unică pentru toate obiectele.
//        Pe lângă aceste câmpuri, poți adăuga orice alte atribute pe care le consideri utile / necesare în implementarea funcționalității
//        cerute și în cadrul jocului.
//
//        Reguli de joc
//        Regulile generale de desfășurare a jocului sunt:
//
//        health:
//        va lua valori între 0 și 100.
//        dacă health ajunge la 0 (sau o valoare negativă) în urma unei operații, se va decrementa numărul de vieți (i.e. lives) cu
//        1 iar health va fi resetat la valoarea maximă, 100. Practic, jucătorul moare și se va mai consuma o viață din numărul de vieți rămase.
//        dacă health trece de valoarea 100 valoarea sa va fi trunchiată la 100. Numărul de vieți rămâne nemodificat (i.e. nu se incrementează numărul de vieți).
//        dacă lives ajunge la valoarea 0 atunci jocul s-a terminat, și se va afișa mesajul Game Over.
//        weaponInHand arma curentă a jucătorului.
//        poate avea una dintre următoarele valori:
//        knife - cost 1000 puncte,
//        sniper- cost 10000 puncte,
//        kalashnikov - cost 20000 puncte.
//        Obs: pentru a compara dacă 2 șiruri de caractere sunt identice, nu se va utiliza operatorul == ci metoda equals(String)
//        aparținând clasei String. Consultă API-ul pentru detalii de utilizare.
//        Obs2: pentru a achiziționa o armă, jucătorul trebuie să aibă un scor minim egal cu valoarea armei. După actualizarea armei,
//        atributul score va fi actualizat în consecință (i.e. score -= weaponPrice).
//        duelul între 2 jucători:
//        dacă cei doi jucători au aceeași armă în mână:
//        se va calcula pentru fiecare o probabilitate de câștig astfel: (3 * health + score / 1000) / 4.
//        jucătorul cu probabilitate mai mare va câștiga lupta.
//        dacă cei doi jucători au arme diferite, puterea armelor depinde de distanța între jucători:
//        distanta > 1000 → puterea armelor descrește astfel: sniper > kalashnikov > knife.
//        distanta ⇐ 1000 → puterea armelor descrește astfel: kalashnikov > sniper > knife.
//        duelul va fi câștigat de jucătorul cu o armă mai puternică, în funcție de distanța dintre cei doi jucători.
//        distanța între 2 jucători:
//        se calculează folosind formula distanței euclidiene, astfel:
//        √(positioXob1−positionXobj2)2+(positionYobj1−positionYobj2)2
//        Comportament
//        Comportamentul unui jucător va include:
//
//        3 metode de inițializare, cu diverse seturi de parametri:
//        initPlayer(nickname): va inițializa doar numele jucătorului (restul câmpurilor vor avea valoarea implicită a tipului).
//        initPlayer(nickname, lives): va inițializa câmpurile aferente: nickname respectiv lives(restul câmpurilor vor avea valoarea implicită a tipului).
//        initPlayer(nickname, lives, score): comportamentul va fi unul asemănător, inițializând câmpurile cu același nume ca parametrii.
//        findArtifact(int artifactCode): metoda va actualiza starea jucătorului în funcție de artifactul găsit, astfel:
//        dacă artifactCode este număr perfect:
//        score se incrementează cu 5000 puncte.
//        lives crește cu 1 viață.
//        health devine 100.
//        dacă artifactCode este număr prim:
//        score se incrementează cu 1000 puncte.
//        lives crește cu 2 vieți.
//        health crește cu 25, dar nu poate depăși valoarea 100.
//        dacă artifactCode este număr par și suma cifrelor sale este divizibilă cu 3 atunci obiectul respectiv este o capcană.
//        Prin urmare, situația jucătorului se modifică astfel:
//        score se decrementează cu 3000 puncte.
//        health se decrementează cu 25.
//        dacă health ajunge la 0, atunci lives va fi decrementat cu 1 și health resetat la 100.
//        orice alte numere nu prezintă „puteri magice“, prin urmare, singura actualizare a stării este:
//        score va fi incrementat cu valoarea artifactCode.
//        Observație: criteriile anterioare se vor testa pe rând (i.e. în ordinea dată) și se va actualiza starea conform primei condiții validate.
//        De exemplu: dacă un artifactCode este atât „număr perfect“ cât și „număr par având suma cifrelor divizibilă cu 3“
//        se va actualiza starea în conformitate cu „număr perfect“ deoarece acest criteriu precede pe celălalt.
//        setWeaponInHand(String weaponInHand): acțiunea va schimba arma folosită de jucător în joc:
//        metoda va verifica inițial dacă arma primită ca argument este o armă validă, conform regulilor jocului.
//        se verifică apoi dacă jucătorul are suficiente puncte acumulate în joc pentru a plăti arma.
//        dacă arma este validă și jucătorul are suficiente puncte pentru achiziție, arma va fi actualizată. Odată cu aceasta,
//        se va actualiza și scorul, pentru a reflecta plata armei cumpărate.
//        metoda returnează true dacă schimbarea armei a avut loc cu succes și false în orice alt caz.
//        getWeaponInHand(): returnează arma curentă a jucătorului.
//        transformă câmpurile positionX și positionY în proprietăți ale obiectelor clasei PlayerStatus.
//        implementează metodele necesare pentru ca atributul gameName să devină o proprietate:
//        va fi acesta o proprietate a fiecărui obiect în parte, sau o proprietate a clasei?
//        implementează corespunzător metodele getter & setter.
//        oricine ar trebui să aibă drept de accesare a proprietății gameName, însă doar „codul“ aparținând aceluiași pachet ar
//        trebui să aibă acces la actualizarea numelui jocului. Actualizează în consecință modificatorii de acces a celor două metode.
//        movePlayerTo(double positionX, double positionY).
//        intuitiv, metoda actualizează poziția jucătorului, prin actualizarea poziției acestuia.
//        numele jucătorului nu ar trebui să poată fi modificat din exterior, însă ar trebui să poată fi citit. Cu alte cuvinte,
//        transformă câmpul nickname într-o proprietate read-only (i.e. care poate fi doar citită public).
//        Hint: Care dintre cele două metode speciale trebuie implementată în acest caz?
//        shouldAttackOpponent(PlayerStatus opponent): metoda simulează o bătălie între jucătorul curent și un adversar, pentru
//        a sfătui jucătorul dacă ar trebui să atace (i.e. ar câștiga o eventuală luptă):
//        metoda returnează true dacă jucătorul curent ar câștiga lupta și false altfel.
//        regulile după care se stabilește învingătorul sunt detaliate în secțiunea de Reguli Generale.
//        OOP-hint: utilizați principiul separării logice a conceptelor implementate în toate metodele implementate.
//        Exemplu: distanța dintre 2 jucători ar trebui calculată într-o metodă separată. Acea metodă trebuie apelată la nevoie,
//        oriunde în cod. Deoarece metoda va fi folosită doar în cadrul implementării clasei, deci intern, ce modificator de acces este cel mai adecvat?
//        Pe lângă acestea, poți implementa orice alte metode (publice sau private) pe care le consideri necesare / utile în
//        cadrul jocului sau în implementarea acțiunilor detaliate anterior.
package Players_fight;

import java.util.Scanner;

public class Player_Status {
//        nickname: un șir de caractere, ce semnifică numele jucătorului.
//        score: un număr întreg, ce reprezintă scorul jucătorului.
//        lives: un număr întreg, ce simbolizează numărul de vieți al jucătorului.
//        health: un număr întreg, între 0 și 100, ce reprezintă procentul de viață rămas.
//        weaponInHand: un șir de caractere ce simbolizează arma jucătorului.
//        positionX: coordonata OX a poziției jucătorului, o valoare numerică reală.
//        positionY: coordonata OY a poziției jucătorului, o valoare numerică reală.
//        gameName: numele jocului.
    private String nickname;
    private int score;
    private int lives;
    private int health;
    private String weaponInHand;
    private double positionX;
    private double positionY;
    private static String gameName="Counter-Strike";
    private static final Scanner sc = new Scanner(System.in);
    private int probability;
    //3 metode de inițializare, cu diverse seturi de parametri:
    //        initPlayer(nickname): va inițializa doar numele jucătorului (restul câmpurilor vor avea valoarea implicită a tipului).
//        initPlayer(nickname, lives): va inițializa câmpurile aferente: nickname respectiv lives(restul câmpurilor vor avea valoarea implicită a tipului).
//        initPlayer(nickname, lives, score): comportamentul va fi unul asemănător, inițializând câmpurile cu același nume ca parametrii.
    public void IntPlayer(String nickname){
        this.nickname = nickname;
    }
    public void IntPlayer(int score,String nickname){
        this.score = score;
        this.nickname = nickname;
    }
    public void IntPlayer(String nickname,int lives,int score){
        this.nickname = nickname;
        this.lives = lives;
        this.score = score;
    }
    //        findArtifact(int artifactCode): metoda va actualiza starea jucătorului în funcție de artifactul găsit, astfel:
//        dacă artifactCode este număr perfect:
//        score se incrementează cu 5000 puncte.
//        lives crește cu 1 viață.
//        health devine 100.
//        dacă artifactCode este număr prim:
//        score se incrementează cu 1000 puncte.
//        lives crește cu 2 vieți.
//        health crește cu 25, dar nu poate depăși valoarea 100.
//        dacă artifactCode este număr par și suma cifrelor sale este divizibilă cu 3 atunci obiectul respectiv este o capcană.
    public static boolean isPrime(int prime_number){
        if(prime_number<2){
            return false;
        }
        for(int i=2;i<=prime_number/2;i++){
            if(prime_number%i==0){
                return false;
            }
        }
        return true;
    }
    public static boolean IsPerfect(int perfect_number){
        int sum=0;
        for(int i=1;i<perfect_number;i++){
            if(perfect_number%i==0){
                sum+=i;
            }
        }
        return sum==perfect_number;
    }
    public static boolean sum_of_digits(int even_number){
        int sum=0;
        int last_number;
        while(even_number!=0){
            last_number=even_number%10;
            even_number/=10;
            sum+=last_number;
        }
        return sum%3==0;
    }
    public static boolean even_number_and_sum_of_digits_is_three(int num){
        return (num%2==0) && (sum_of_digits(num));
    }
    public void findArtifact(int artifactCode){
        if(isPrime(artifactCode)){
            this.score+=5000;
            this.lives+=1;
            this.health=100;
        } else if (IsPerfect(artifactCode)) {
            this.score+=1000;
            this.lives+=2;
            this.health+=25;
            if(this.health>100){
                this.health = 100;
            }
        } else if (even_number_and_sum_of_digits_is_three(artifactCode)) {
            System.out.println("Obiectul este o capcana");
            this.score-=3000;
            this.health-=25;
            if(this.health==0){
                this.lives--;
                this.health=100;
            }
        } else{
            this.score+=artifactCode;
        }
    }
    public boolean setWeaponInHand() {
        System.out.println("Introduceti optiunea dorita:");
        System.out.println("1.Achizionati arma knife");
        System.out.println("2.Achizionati arma kalashnikov");
        System.out.println("3.Achizionati arma sniper");
        int option = sc.nextInt();
        if (option == 1) {
            if ((this.score >= 1000)) {
                this.weaponInHand = "knife";
                this.score -= 1000;
                return true;
            }
        } else if (option == 2) {
            if ((this.score >= 10000)) {
                this.weaponInHand = "kalashnikov";
                this.score -= 10000;
                return true;
        }
            } else if (option == 3) {
                if ((this.score >= 20000)) {
                    this.weaponInHand = "sniper";
                    this.score -= 20000;
                    return true;
            }
        }
        return false;
        }
    public String getWeaponInHand(){
        return this.weaponInHand;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    public static String getGameName(){
        return gameName;
    }
    public static void setGameName(String gameName){
        Player_Status.gameName=gameName;
    }
    public void movePlayerTo(double positionX,double positionY){
        this.positionX = positionX;
        this.positionY = positionY;
    }
    public String getNickname(){
        return this.nickname;
    }
     private double distance(Player_Status oponent){
        //return Math.sqrt((this.positionX-oponent.positionX)*((this.positionX-oponent.positionX)+(this.positionY- oponent.positionY)*(this.positionY- oponent.positionY)));
        double X = Math.pow((this.positionX-oponent.positionX),2);
        double Y = Math.pow((this.positionY-oponent.positionY),2);
        return Math.sqrt(X+Y);
    }
    public boolean shouldAttackOpponent(Player_Status opponent){
        if(this.weaponInHand.equals(opponent.weaponInHand)){
            probability=(3*health+score/1000)/4;
            opponent.probability=(3*opponent.health+opponent.score/1000)/4;
            if(this.probability>opponent.probability){
                return true;
            } else {
                return false;
            }
        }
        else{
            if(opponent.distance(opponent)>1000){
                if(this.weaponInHand.equals("kalashnikov")){
                    return true;
                } else if (opponent.weaponInHand.equals("kalashnikov")) {
                    return false;
                }
                if(this.weaponInHand.equals("kalashnikov") && opponent.weaponInHand.equals("knife")){
                    return true;
                }
                if(this.weaponInHand.equals("knife") && opponent.weaponInHand.equals("kalashnikov")){
                    return false;
                }
                if(this.weaponInHand.equals("kalashnikov") && opponent.weaponInHand.equals("sniper")){
                    return false;
                }
                if(this.weaponInHand.equals("knife") && opponent.weaponInHand.equals("sniper")){
                    return false;
                }
            }
            else{
                if(distance(opponent)<=1000){
                    if(opponent.distance(opponent)>1000){
                        if(this.weaponInHand.equals("sniper")){
                            return true;
                        } else if (opponent.weaponInHand.equals("sniper")) {
                            return false;
                        }
                        if(this.weaponInHand.equals("kalashnikov") && opponent.weaponInHand.equals("knife")){
                            return true;
                        }
                        if(this.weaponInHand.equals("knife") && opponent.weaponInHand.equals("kalashnikov")){
                            return false;
                        }
                        if(this.weaponInHand.equals("sniper") && opponent.weaponInHand.equals("kalashnikov")){
                            return false;
                        }
                        if(this.weaponInHand.equals("knife") && opponent.weaponInHand.equals("sniper")){
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }
    public void displayPlayerStatus(){
        System.out.format("+-------------------------+----------+----------+---------+--------------------------+%n");
        System.out.format("+-------------------------+----------+----------+---------+--------------------------+%n");
        System.out.printf("|        Player name      | Lives    | Score    | Health  |          Weapon          |%n");
        System.out.format("+-------------------------+----------+----------+---------+--------------------------+%n");
        System.out.printf("|         " + getNickname() + "     |   " + lives + "      |  " + score + "   |  " + health + "      |   " + getWeaponInHand() + "            |%n");
        System.out.format("+-------------------------+----------+----------+---------+--------------------------+%n");
        System.out.println();
    }
    public void attackOpponent(Player_Status opponent){
        switch (weaponInHand){
            case "knife":
                opponent.health-=25;
            case "kalashnikov":
                opponent.health-=50;
            case "sniper":
                opponent.health-=100;
        }
        if(opponent.health<=0){
            opponent.health=100;
            opponent.lives--;
        }
        if(opponent.lives==0){
            System.out.println("Game Over");
            opponent.health=0;
        }
    }
}
//modificatori de access:
//1.public(clasa este vizibila in orice pachet din proiect)
//2.protected(clasa este vizibila in pachetul din care fac parte si de catre clasele care mostenesc clasa)
//3.private(clasa este vizibila doar in cadrul clasei)
//package private(default) doar in cadrul pachetului
//static este un keyword prin care se marcheaza un field ca avand aceeasi valoare pentru toate obiectele clasei
//metodele statice sunt metode care se apeleaza prin numele clasei,nu prin obiect.prelucreaza field-uri statice
//obiectul curent al clasei este this

//shouldAttack + try-catch + corner cases