package ui;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

import domain.Adresboek;
import domain.Contact;

public class AdresboekApp {
	public static int test0 = 1;
	public static final int test1 = 1;

	public static void main(String[] args) {
		test0 = 0;
		System.out.println(test0 );
		System.out.println(test1 );

	}
}

/*
//Verwachte output
Alle contacten uit adresboek 1 in volgorde van toevoeging
Aantal contacten:7
Depeel         Andi            016111111
Depeel         Els             016111111
Dox            Jo              016222211
Adons          Andi            016111333
Adons          Dirk            016111333
Vranken        Rita            011999999
Vangeel        Anja            011111112

Alle contacten uit adresboek 2 in volgorde van toevoeging
Aantal contacten:8
Depeel         Els             016111111
Degrijse       Jan             011224511
Adons          Andi            016111333
Depeel         Andi            016111111
Adons          Robrecht        016111333
Vranken        Rita            011999999
Vanlo          Kris            016190111
Dero           Eno             011111112

Alle gemeenschappelijke contacten uit adresboek 1 en adresboek 2 in alfabetische volgorde achternaam/voornaam
Aantal contacten:4
Adons          Andi            016111333
Depeel         Andi            016111111
Depeel         Els             016111111
Vranken        Rita            011999999

Alle gezamelijke contacten uit adresboek 1 en adresboek 2 in alfabetische volgorde achternaam/voornaam
Aantal contacten:11
Adons          Andi            016111333
Adons          Dirk            016111333
Adons          Robrecht        016111333
Degrijse       Jan             011224511
Depeel         Andi            016111111
Depeel         Els             016111111
Dero           Eno             011111112
Dox            Jo              016222211
Vangeel        Anja            011111112
Vanlo          Kris            016190111
Vranken        Rita            011999999

Alle contacten uit adresboek 1 die niet voorkomen in adresboek 2 in alfabetische volgorde achternaam/voornaam
Aantal contacten:3
Adons          Dirk            016111333
Dox            Jo              016222211
Vangeel        Anja            011111112

Dox Jo niet toegevoegd aan adresboek 1
Rummens Rani toegevoegd aan adresboek 1
Aantal verwijderde contacten met achternaam Adons uit adresboek 1:2
Alle contacten uit adresboek 1 in volgorde van toevoeging na aanpassingen
Aantal contacten:6
Depeel         Andi            016111111
Depeel         Els             016111111
Dox            Jo              016222211
Vranken        Rita            011999999
Vangeel        Anja            011111112
Rummens        Rani            013288338
*/
