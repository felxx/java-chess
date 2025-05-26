package chess;

import boardgame.Position;

public abstract class ChessPiece {
	private Color color;
	private int moveCount;
	
	public ChessPiece(Color color, int moveCount) {
		this.color = color;
		this.moveCount = moveCount;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getMoveCount() {
		return moveCount;
	}
	
	protected boolean isThereOpponentPiece(Position position) {
		return false;
	}
	
	protected void increaseMoveCount() {
		
	}
	
	protected void decreaseMoveCount() {
		
	}
}
