package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();

		while(!chessMatch.getCheckMate()){
			try{
				UI.clearScreen();
				UI.printMatch(chessMatch, captured);
				System.out.println();

				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				System.out.println();

				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				System.out.println();
				
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
				System.out.println();

				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

				if(captured != null) {
					captured.add(capturedPiece);
				}

				if(chessMatch.getPromoted()!=null){
					System.out.println("Enter piece promotion: (B/N/R/Q)");
					String type = sc.nextLine().toUpperCase();
					while(!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")){
						System.out.println("Invalid value! Enter piece promotion: (B/N/R/Q)");
						type = sc.nextLine().toUpperCase();
					}
					chessMatch.replacePromotedPiece(type);
					System.out.println();
				}
			}
			catch (ChessException e){
				System.out.println();
				System.out.println(e.getMessage());
				sc.nextLine();
			}

			catch (InputMismatchException e){
				System.out.println();
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
	}
}
