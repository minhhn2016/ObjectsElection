/**
 * Created by Minh Hoang on 25/10/2017. A Modified version of the original ArrayElection program, now using ArrayList of Candidate objects.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ObjectsElectionProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int topVote = 0;
        String winner = "";
        boolean duplicate = false;

        System.out.println("Enter the number of candidates: ");
        int numberOfCandidates = Integer.parseInt(input.nextLine());

        // Arrays to hold initial user inputs
        //String[] candidatesNameArr = new String[numberOfCandidates];
        //int[] candidatesVoteArr = new int[numberOfCandidates];

        // ArrayList that holds the candidates and votes
        ArrayList<Candidate> candidateList = new ArrayList<Candidate>();

        // Adds candidates to the candidateList
        while (!(candidateList.size() >= numberOfCandidates)) {
            System.out.println("Enter " + (candidateList.size() + 1) + ". name: ");
            candidateList.add(new Candidate(input.nextLine()));
            System.out.println("Enter votes: ");
            candidateList.get(candidateList.size() - 1).setVotes(Integer.parseInt(input.nextLine()));

        }

        // An empty list to hold the winner(s)
        ArrayList<Candidate> winnersList = new ArrayList<Candidate>();

        // Check for winner from the original candidateList, add winner to winnerList
        for (Candidate candidate : candidateList
                ) {
            if (candidate.getVotes() >= topVote) {
                topVote = candidate.getVotes();
                winnersList.add(candidate);
                for (Candidate winningCandidate : winnersList
                        ) {
                    // Remove loosing candidate from winnerList
                    if (winningCandidate.getVotes() < topVote) {
                        winnersList.remove(winningCandidate);
                    }
                }
            }
        }

        // If there are multiple winners.
        if (winnersList.size() > 1) {
            duplicate = true;
        }
        /*
        // Arrays to hold results
        String[] winnersNameArr = new String[numberOfCandidates];
        int[] winnersVoteArr = new int[numberOfCandidates];

        // Loop to fill up initial array of inputs
        for (int i = 0; i < numberOfCandidates; i++) {
            System.out.println("Enter " + (i + 1) + ". name: ");
            candidatesNameArr[i] = input.nextLine();
            System.out.println("Enter votes: ");
            candidatesVoteArr[i] = Integer.parseInt(input.nextLine());
        }

        // Loop to sort filled arrays based on votes
        for (int i = 0; i < candidatesVoteArr.length; i++) {
            for (int j = i + 1; j < candidatesVoteArr.length; j++) {
                if (candidatesVoteArr[j] > candidatesVoteArr[i]) {
                    topVote = candidatesVoteArr[j];
                    winner = candidatesNameArr[j];
                    candidatesVoteArr[j] = candidatesVoteArr[i];
                    candidatesNameArr[j] = candidatesNameArr[i];
                    candidatesVoteArr[i] = topVote;
                    candidatesNameArr[i] = winner;
                }
            }
        }

        // Assign winner and corresponding vote to the winner array
        //winnersVoteArr[0] = candidatesVoteArr[0];
        //winnersNameArr[0] = candidatesNameArr[0];

        // Check for duplicate winners
        for (int i = 1; i < candidatesVoteArr.length; i++) {
            if (candidatesVoteArr[i] == candidatesVoteArr[0]) {
                //winnersVoteArr[i] = candidatesVoteArr[i];
                //winnersNameArr[i] = candidatesNameArr[i];
                duplicate = true;
            }
        }
        */
        // Display results
        if (!duplicate) {
            System.out.println("The winner is " + winnersList.get(0).getName() + " with " + winnersList.get(0).getVotes() + " votes!");
        } else {
            System.out.println("The election is a tie between the following candidates: ");
            /*for (int i = 0; i < winnersVoteArr.length; i++) {
                if (candidatesVoteArr[i] == candidatesVoteArr[0]) {
                    System.out.println(candidatesNameArr[i] + " (" + candidatesVoteArr[i] + " votes)");
                }
            }*/
            for (Candidate winningCandidate : winnersList
                    ) {
                System.out.println(winningCandidate.getName() + " (" + winningCandidate.getVotes() + " votes)");
            }
        }


    }
}


