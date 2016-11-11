/*
 * NorbironSurfaceView.java
 *
 * Norbiron Game
 * This is a case study for creating sprites for SamuEntropy/Brainboard.
 *
 * Copyright (C) 2016, Dr. Bátfai Norbert
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Ez a program szabad szoftver; terjeszthető illetve módosítható a
 * Free Software Foundation által kiadott GNU General Public License
 * dokumentumában leírtak; akár a licenc 3-as, akár (tetszőleges) későbbi
 * változata szerint.
 *
 * Ez a program abban a reményben kerül közreadásra, hogy hasznos lesz,
 * de minden egyéb GARANCIA NÉLKÜL, az ELADHATÓSÁGRA vagy VALAMELY CÉLRA
 * VALÓ ALKALMAZHATÓSÁGRA való származtatott garanciát is beleértve.
 * További részleteket a GNU General Public License tartalmaz.
 *
 * A felhasználónak a programmal együtt meg kell kapnia a GNU General
 * Public License egy példányát; ha mégsem kapta meg, akkor
 * tekintse meg a <http://www.gnu.org/licenses/> oldalon.
 *
 * Version history:
 *
 * 0.0.1, 2013.szept.29.
 */
package batfai.samuentropy.brainboard7;

import android.util.Log;
import java.io.*;
import android.content.Context;


class Nodes {

    private android.graphics.Bitmap boardPic;
    private android.graphics.Bitmap neuronSprite;
    private android.graphics.Bitmap nandIronProcCover;
    private NeuronBox[] neuronBox;

    public Nodes(android.view.SurfaceView surfaceView) {
        int resId = surfaceView.getResources().getIdentifier("pcb550i", "drawable",
                "batfai.samuentropy.brainboard7");

        boardPic = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);

        boardPic = android.graphics.Bitmap.createScaledBitmap(boardPic, 300, 300, false);

        resId = surfaceView.getResources().getIdentifier("neuronsprite", "drawable",
                "batfai.samuentropy.brainboard7");

        neuronSprite = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);

        neuronSprite = android.graphics.Bitmap.createScaledBitmap(neuronSprite, 64 * 2 * 14, 62, false);

        resId = surfaceView.getResources().getIdentifier("nandironproci", "drawable",
                "batfai.samuentropy.brainboard7");
        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox = new NeuronBox[8];
        neuronBox[0] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 100, nandIronProcCover, 64, 62 + 197 + 128 - 27);

        resId = surfaceView.getResources().getIdentifier("nandironproci2", "drawable",
                "batfai.samuentropy.brainboard7");
        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox[1] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 10, nandIronProcCover, 64 + 168 + 130, 128 + 197 + 62 -27);

        resId = surfaceView.getResources().getIdentifier("matyironproci", "drawable",
                "batfai.samuentropy.brainboard7");
        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox[2] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 15, nandIronProcCover, 64, 62 + 2 *197 + 2 *128 - 2*27);

        resId = surfaceView.getResources().getIdentifier("matyironproci2", "drawable",
                "batfai.samuentropy.brainboard7");
        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox[3] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 100, nandIronProcCover, 64 + 168 + 130, 62 + 2 *197 + 2*128 - 2*27);

        resId = surfaceView.getResources().getIdentifier("gretironproci", "drawable",
                "batfai.samuentropy.brainboard7");
        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox[4] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 10, nandIronProcCover, 64, 62 + 3 *197 + 3*128 - 3*27);

        resId = surfaceView.getResources().getIdentifier("gretironproci2", "drawable",
                "batfai.samuentropy.brainboard7");
        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox[5] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 15, nandIronProcCover, 64 + 168 + 130, 62 + 3 *197 + 3*128 - 3*27);

        resId = surfaceView.getResources().getIdentifier("buildproci", "drawable",
                "batfai.samuentropy.brainboard7");
        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox[6] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 15, nandIronProcCover, 64, 62);
        neuronBox[6].setType(-1);

        resId = surfaceView.getResources().getIdentifier("deleteproci", "drawable",
                "batfai.samuentropy.brainboard7");
        nandIronProcCover = android.graphics.BitmapFactory.decodeResource(surfaceView.getResources(), resId);
        nandIronProcCover = android.graphics.Bitmap.createScaledBitmap(nandIronProcCover, 168, 197, false);

        neuronBox[7] = new NeuronBox(neuronSprite, 2 * 14, 64, 62, 15, nandIronProcCover, 64 + 168 + 130, 62);
        neuronBox[7].setType(-2);
    }

    public android.graphics.Bitmap getBoardPic() {
        return boardPic;
    }

    public NeuronBox get(int i) {
        return neuronBox[i];
    }

    public int getSize() {
        return neuronBox.length;
    }

}

/**
 *
 * @author nbatfai
 */
public class NorbironSurfaceView extends android.view.SurfaceView implements Runnable {

    private String dataFile = "NorbironTableData";
    private String dataSeparator = " ";
    private boolean deleteInProgress = false;

    private float startsx = 0;
    private float startsy = 0;
    private float width = 2048;
    private float height = 2048;

    protected float swidth;
    protected float sheight;

    protected float fromsx;
    protected float fromsy;

    protected float boardx = 0;
    protected float boardy = 0;

    private Nodes nodes;
    private static java.util.List<NeuronBox> nodeBoxes = new java.util.ArrayList<NeuronBox>();

    protected NeuronBox selNb = null;

    private android.view.SurfaceHolder surfaceHolder;
    private android.view.ScaleGestureDetector scaleGestureDetector;
    private float scaleFactor = 1.0f;

    private boolean running = true;

    private Context context;


    public void setScaleFactor(float scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    public float getScaleFactor() {
        return scaleFactor;
    }

    public NorbironSurfaceView(Context context) {
        super(context);

        cinit(context);

    }

    public NorbironSurfaceView(Context context,
            android.util.AttributeSet attrs) {
        super(context, attrs);

        cinit(context);

    }

    public NorbironSurfaceView(Context context,
            android.util.AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        cinit(context);

    }

    @Override
    protected void onSizeChanged(int newx, int newy, int x, int y) {

        Log.d("ONSIZECHANGED", "EXECUTING...");
        super.onSizeChanged(newx, newy, x, y);

        width = newx;
        height = newy;

        swidth = width / 2 - nodes.getBoardPic().getWidth() / 2;
        sheight = height / 2 - nodes.getBoardPic().getHeight() / 2;

    }

    private void saveData(){

            try{
                FileOutputStream outfile = context.openFileOutput(dataFile, Context.MODE_PRIVATE);

                for(NeuronBox nb : nodeBoxes){
                    if(nb.getType() != -1 && nb.getType() != -2){  
                        String tmp = nb.getType() + dataSeparator + 
                                     nb.getX() + dataSeparator + 
                                     nb.getY() + '\n';
                        outfile.write(tmp.getBytes());
                        Log.d("SAVE_DATA", tmp);
                    }
                }
                outfile.close();
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }

            Log.d("SAVE_DATA", "data written to outfile");


    }

    private void cinit(Context context) {

        this.context = context;
        nodes = new Nodes(this);
        Log.d("CINIT", "EXECUTING....");

        if (nodeBoxes.size() == 0) {
            nodeBoxes.add((NeuronBox) nodes.get(6).clone());
            nodeBoxes.add((NeuronBox) nodes.get(7).clone());
        }

        android.content.Intent intent = ((NeuronGameActivity) context).getIntent();
        android.os.Bundle bundle = intent.getExtras();

        if (bundle != null ) {
            int i = bundle.getInt("batfai.samuentropy.brainboard7.selectedNode");

            Log.d("CINIT", "BUNDLE NOT NULL: s" + i);
            NeuronBox node = (NeuronBox)nodes.get(i).clone();
            node.setType(i);
            nodeBoxes.add(node);
            saveData();

        }
        else if(nodeBoxes.size() == 2){


            try{
                Log.d("CINIT", "BUNDLE NULL");
                java.io.FileInputStream infile = context.openFileInput(dataFile);

                String temp = "";
                int c;

                //Reading the nodes:
                while( ( c = infile.read() ) != -1){
                    
                    if( (char)c == '\n'){

                        int type = Integer.parseInt( temp.substring(0, temp.indexOf(' ')) );
                        temp = temp.substring( temp.indexOf(' ') + 1 );
                        int xPos = Integer.parseInt( temp.substring(0, temp.indexOf(' ')) );
                        temp = temp.substring( temp.indexOf(' ') + 1);
                        int yPos = Integer.parseInt( temp );

                        temp = "";

                        Log.d("Loadingback..", type + " " + xPos + " " + yPos);

                        NeuronBox node = (NeuronBox) nodes.get(type).clone();
                        node.setType(type);
                        node.setXY((float)xPos, (float)yPos);
                        nodeBoxes.add(node);
                        
                    }else{
                        temp = temp + Character.toString((char)c);

                    }
                }

                infile.close();

            }catch(FileNotFoundException e){
                e.printStackTrace();
                Log.w("CINIT", "App running for first time, no input file yet...");
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        surfaceHolder = getHolder();
        surfaceHolder.addCallback(new SurfaceEvents(this));

        scaleGestureDetector = new android.view.ScaleGestureDetector(context, new ScaleAdapter(this));

    }

    @Override
    public void onDraw(android.graphics.Canvas canvas) {

        if (surfaceHolder.getSurface().isValid()) {

            canvas.save();
            canvas.scale(scaleFactor, scaleFactor);

            canvas.drawColor(android.graphics.Color.BLACK);

            for (int i = 0; i < 10; ++i) {
                for (int j = 0; j < 10; ++j) {
                    canvas.drawBitmap(nodes.getBoardPic(), -startsx + boardx + i * 300, -startsy + boardy + j * 300, null);
                }
            }

            if(!deleteInProgress){
                for (NeuronBox nb : new java.util.ArrayList<NeuronBox>(nodeBoxes)) {
                    if(nb.getType() == -1){
                        nb.setXY(64, 62);
                    }
                    if(nb.getType() == -2){
                        nb.setXY( 64 + 168 + 128, 62);
                    }
                    nb.draw(-startsx, -startsy, canvas);
                    
                }
            }else{
                nodeBoxes.get(0).draw(-startsx, -startsy, canvas);
                nodeBoxes.get(1).draw(-startsx, -startsy, canvas);
                nodeBoxes.clear();
                nodeBoxes.add((NeuronBox) nodes.get(6).clone());
                nodeBoxes.add((NeuronBox) nodes.get(7).clone());
                saveData();
                deleteInProgress = false;
            }

            canvas.restore();
        }
    }

    public void repaint() {

        android.graphics.Canvas canvas = null;
        try {
            canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                onDraw(canvas);
            }

        } finally {

            if (canvas != null) {
                surfaceHolder.unlockCanvasAndPost(canvas);
            }

        }
    }

    public float d(float x1, float x2, float y1, float y2) {

        return (x1 - y1) * (x1 - y1) + (x2 - y2) * (x2 - y2);
    }

    protected NeuronBox nearestNeuronBox(float x, float y) {

        NeuronBox r = null;
        float max = 10000, m;

        for (NeuronBox nb : nodeBoxes) {

            if ((m = d(nb.getX() + nb.getWidth() / 2, nb.getY() + nb.getHeight() / 2, x, y)) < max) {
                max = m;
                r = nb;
            }
        }
        return r;
    }

    public void newNode() {

        android.content.Intent i = new android.content.Intent(context, NodeActivity.class);
        context.startActivity(i);

    }

    @Override
    public boolean onTouchEvent(android.view.MotionEvent event) {

        scaleGestureDetector.onTouchEvent(event);

        float x = event.getX() / scaleFactor;
        float y = event.getY() / scaleFactor;

        if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {

            fromsx = x;
            fromsy = y;

            NeuronBox nb = nearestNeuronBox(x + startsx, y + startsy);
            if (nb != null) {

                if (nb.getType() == -1) {
                    if (!nb.getSelected()  ) {
                        nb.setCover(false);
                        newNode();
                    }
                }else if(nb.getType() == -2){
                    if( !nb.getSelected() ){
                        nb.setCover(false);
                        
                        deleteInProgress = true;
                        return true;
                    }
                }else{

                    nb.setCover(!nb.getCover());
                    nb.setSelected(!nb.getSelected());
                }

                selNb = nb;

            } else {
                selNb = null;
            }

        } else if (event.getAction() == android.view.MotionEvent.ACTION_POINTER_DOWN) {

            if (selNb != null) {
                selNb = null;
            }

        } else if (event.getAction() == android.view.MotionEvent.ACTION_CANCEL) {

        } else if (event.getAction() == android.view.MotionEvent.ACTION_MOVE) {

            if (selNb != null) {
                selNb.setXY(selNb.getX() - (fromsx - x), selNb.getY() - (fromsy - y));

                fromsx = x;
                fromsy = y;

            } else if (Math.abs(fromsx - x) + Math.abs(fromsy - y) > 25) {
                startsx += (fromsx - x);
                startsy += (fromsy - y);

                fromsx = x;
                fromsy = y;
            }

        } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {

            if(selNb != null){
                saveData();
            }
        }

        return true;
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        long now = System.currentTimeMillis(), newnow;
        float spritex = 0;
        running = true;
        while (running) {

            if ((newnow = System.currentTimeMillis()) - now > 100) {

                for (NeuronBox nb : nodeBoxes) {
                    nb.step();
                }

                repaint();


                now = newnow;
            }

        }

    }
}
