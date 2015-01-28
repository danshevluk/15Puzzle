package gui;

import model.FPCell;
import model.FPPuzzle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Игровое поле с клетками
 */
public class FRPuzzlePanel extends JPanel {
    private FPPuzzle puzzle;
    private FPCellView cellViews[];
    //TODO: добавить размеры пазла и размер одной клетки и использовать их в cellClicked

    public FRPuzzlePanel() {
        setLayout(new GridLayout(4, 4));
        initComponents();

    }


    @Override
    public Dimension getPreferredSize(){
        return new Dimension((int)(4 * cellViews[0].getPreferredSize().getWidth()),
                (int)(4 * cellViews[0].getPreferredSize().getHeight()));
    }

    public void initComponents() {
        puzzle = new FPPuzzle();
        cellViews = new FPCellView[puzzle.getSize()];
        for (int i = 0; i < cellViews.length; i++) {
            cellViews[i] = new FPCellView(puzzle.get(i));
            add(cellViews[i]);
        }

    }

    public FPPuzzle getPuzzle() {
        return puzzle;
    }

    public void makeCellViewsResizable() {
        for (int i = 0; i < cellViews.length; i++) {
            addComponentListener(cellViews[i]);
        }
    }

    public void makeViewsReactAtClicks(){
        for (int i = 0; i < cellViews.length; i++) {
            addMouseListener(cellViews[i]);
        }
    }

    public void cellClicked(java.awt.event.MouseEvent evt) {
        int row = 0;
        int column = 0;
        //TODO: добыть кликнутую строку и столбец из фрейма используя размеры
        //
        // evt.getX() evt.getY()
        //

        //TODO: преобразовать две координаты в индекс используя размеры поля из puzzle
        // чтобы не хардкодить и можно было бы
        // потом сделеать поле не 16 клеток, а больше

        int index = 0;
        puzzle.moveMePlease(index);
    }


}
