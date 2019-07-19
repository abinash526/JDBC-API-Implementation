package com.stackroute.jdbc;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;

public class ActionListerRowSet implements RowSetListener {
    @Override
    public void rowSetChanged(RowSetEvent event) {

    }

    @Override
    public void rowChanged(RowSetEvent event) {
        System.out.println("Row Changed");

    }

    @Override
    public void cursorMoved(RowSetEvent event) {
        System.out.println("Cursor Moved");

    }
}
