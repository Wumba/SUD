# Begrüßung
Guten Tag Frau Rollins,
wie gehabt verwende ich mehrere Klassen die Objekte voneienander erstellen und <br>
werde dementsprechend alles als Paket ein Paket hochladen.

## Begründung der Verwendung der Schleifen

### Alle

Bei allen wird die Eingabe wiederholt, wenn der Benutzer das möchte.<br>
Dies habe ich aus Gewohnheit in "Konto" und "Teiler" mit einer kopf- und bedingungsgesteuerten Schleife getan.<br>
Wobei man die meisten Verwendungen von kopfgesteuerten Schleifen auch durch fußgesteurte Schleifen ersetzen könnte,<br>
da man den Code mindestens einmal durchlaufen möchte. 

Des Weiteren sparen fußg. Schleifen eine Abfrage und eine
Initalisierung:

```java
boolean keepGoing = true;
while (keepGoing) {
    System.out.println("Keep Going");
    keepGoing = doesUserWantToContinue();
}
```

```java
boolean keepGoing;
do {
  System.out.println("Keep Going");
    keepGoing = doesUserWantToContinue();
} while (keepGoing);
```
 
Auf der anderen Seite lasse sich kopfgesteuerte Schleifen leichter debuggen, da die Bedingung direkt zu Beginn steht.
Da die Speicherersparnis durch Nutzung einer do-while-Schleife im Gegensatz zu einer while-Schleife vermutlich <br>
nur gering ist, vermute ich, dass die Verwendung einfach auf persönlicher Präferenz beruht, wobei ich in aktuellem <br>
Java Code noch sehr wenige fußg. Schleifen gesehen habe.

## Zählergesteuerte Schleife

Die zählergesteuerte Schleife verwendete ich in der Klasse "Teiler",<br>
da ich Widerholungen bis zu einer vordefinierten Grenze erreichen wollte (i<input).

Auch in der Klasse "Primzahlen" hätte man eine kopfgesteurte Schleife verwenden können:

```java
for (i = 2; i < inputNumber && remainder != 0; i++) {
    remainder = inputNumber % i;
    System.out.println("i:" + i + " ;remainder: " + remainder);
}
```

## Fazit

Man kann fast jede Aufgabe so hinbiegen, dass man jede Art von Schleife verwenden könnte.
