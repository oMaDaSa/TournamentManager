package utils;

import objects.Match;
import objects.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private final String path;

    public FileHandler(String path){
        this.path = path;
    }

    public void updatePlayers(Match match){
        ArrayList<Player> players = readPlayers();

        int pWinnerPoints = match.getTie() ? 1 : 2;
        int pLooserPoints = match.getTie() ? 1 : 0;

        Player winner = match.getWinner();
        Player looser = match.getLooser();
        for(Player i : players) {
            if (i.equals(winner)) {
                i.setPoints(winner.getPoints() + 2);
                i.setPointBalance(winner.getPointBalance() + match.getWinnerPoints());
            }
            else if (i.equals(looser)) {
                i.setPointBalance(looser.getPointBalance() + match.getLooserPoints());
            }
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
            oos.writeObject(players);
            System.out.println("Dados salvos com sucesso no arquivo: " + path);
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    public void savePlayers(Player player){
        ArrayList<Player> currentPlayers = readPlayers();
        if(currentPlayers.stream().anyMatch(allPlayers -> allPlayers.getName().equals(player.getName()))){
            System.out.println("Jogador ja existe");
            return;
        }
        currentPlayers.add(player);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
            oos.writeObject(currentPlayers);
            System.out.println("Dados salvos com sucesso no arquivo: " + path);
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    public ArrayList<Player> readPlayers(){
        File file = new File(path);

        createFileIfNotExists(path);

        // Verifica se o arquivo está vazio
        if (file.length() == 0) {
            System.out.println("Arquivo vazio, retornando lista vazia.");
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (ArrayList<Player>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao ler os dados: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void saveMatches(Match match){
        ArrayList<Match> currentMatches = readMatches();
        currentMatches.add(match);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
            oos.writeObject(currentMatches);
            System.out.println("Dados salvos com sucesso no arquivo: " + path);
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    public ArrayList<Match> readMatches(){
        File file = new File(path);

        createFileIfNotExists(path);

        // Verifica se o arquivo está vazio
        if (file.length() == 0) {
            System.out.println("Arquivo vazio, retornando lista vazia.");
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (ArrayList<Match>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao ler os dados: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void createFileIfNotExists(String path){
        File file = new File(path);
        if(!file.exists()){
            try{
                if(file.createNewFile()){
                    System.out.println("arquivo criado");
                }
            }catch (Exception e){
                System.out.println();
            }
        }else{
            System.out.println("arquivo ja existe");
        }
    }
}
