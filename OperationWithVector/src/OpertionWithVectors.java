import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpertionWithVectors {


    public static void main(String[] args) {

        swing();


    }


    public static VectorFromCoordinates sumVectors(VectorFromCoordinates a, VectorFromCoordinates b){
        VectorFromCoordinates sum = new VectorFromCoordinates();
        sum.x = a.x + b.x;
        sum.y = a.y + b.y;
        return sum;
    }

    public  static VectorFromCoordinates subVectors(VectorFromCoordinates a, VectorFromCoordinates b){
        VectorFromCoordinates sub = new VectorFromCoordinates();
        sub.x = a.x - b.x;
        sub.y = a.y - b.y;
        return sub;
    }

    public static double multiplicationVectors(VectorFromCoordinates a, VectorFromCoordinates b){
        double res =  (a.x * b.x) + (a.y * b.y);
        return res;
    }
    public static double angleBetweenVectors(VectorFromCoordinates a, VectorFromCoordinates b){
        double res = 0;
        res =   Math.acos(multiplicationVectors(a, b) / (Math.sqrt(Math.pow(a.x,2) + Math.pow(a.y,2)) * Math.sqrt(Math.pow(b.x,2) + Math.pow(b.y,2)) ));
        res = Math.toDegrees(res);
        return res;
    }

    public static double angleBetweenVectorAndOX(VectorFromCoordinates a) {
        double res = 0;
        res = angleBetweenVectors(a,  new VectorFromCoordinates(new VectorFromPoints(new Point(0,0), new Point(1,0))));
        if (res > 180){
            res = 360 - 180;
        }
        return res;
    }


    public static void swing(){
        JFrame f = new JFrame();
        f.setLayout(null);
        f.setVisible(true);
        JButton button1 = new JButton("Sum");
        button1.setBounds(0, 300, 130, 50);

        JButton button2 = new JButton("Substitution");
        button2.setBounds(150, 300, 130, 50);

        JButton button3 = new JButton("multiplication");
        button3.setBounds(300, 300, 130, 50);

        JButton button4 = new JButton("AngleBetweenVec");
        button4.setBounds(450, 300, 150, 50);
        f.add(button1);
        f.add(button2);
        f.add(button3);
        f.add(button4);


        JTextField StartPointVector1 = new JTextField("StartPointVector1:");
        StartPointVector1.setBounds(10, 30, 100, 20);
        JTextField EndPointVector1 = new JTextField("EndtPointVector1");
        EndPointVector1.setBounds(10, 80, 100, 20);
        f.add(StartPointVector1);
        f.add(EndPointVector1);

        JTextField v1SpointX1 = new JTextField();
        v1SpointX1.setBounds(150, 30, 100, 20);
        JTextField v1SpointY1 = new JTextField();
        v1SpointY1.setBounds(290, 30, 100, 20);
        f.add(v1SpointX1);
        f.add(v1SpointY1);

        JTextField v1EpointX2 = new JTextField();
        v1EpointX2.setBounds(150, 80, 100, 20);
        JTextField v1EpointY2 = new JTextField();
        v1EpointY2.setBounds(290, 80, 100, 20);
        f.add(v1EpointX2);
        f.add(v1EpointY2);

        JTextField StartPointVector2 = new JTextField("StartPointVector2:");
        StartPointVector2.setBounds(10, 130, 100, 20);
        JTextField EndPointVector2 = new JTextField("EndtPointVector2");
        EndPointVector2.setBounds(10, 180, 100, 20);
        f.add(StartPointVector2);
        f.add(EndPointVector2);

        JTextField v2SpointX1 = new JTextField();
        v2SpointX1.setBounds(150, 130, 100, 20);
        JTextField v2SpointY1 = new JTextField();
        v2SpointY1.setBounds(290, 130, 100, 20);
        f.add(v2SpointX1);
        f.add(v2SpointY1);

        JTextField v2EpointX2 = new JTextField();
        v2EpointX2.setBounds(150, 180, 100, 20);
        JTextField v2EpointY2 = new JTextField();
        v2EpointY2.setBounds(290, 180, 100, 20);
        f.add(v2EpointX2);
        f.add(v2EpointY2);


        JFrame FrameRes = new JFrame();
        FrameRes.setLayout(null);

        JTextField text = new JTextField("RESPONSE");
        text.setBounds(50, 10, 100, 20);
        FrameRes.add(text);

        JTextField res = new JTextField();
        res.setBounds(50, 50, 100, 20);
        FrameRes.add(res);
        f.setSize(600, 500);
        FrameRes.setSize(200, 200);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point V1Start = new Point();
                Point V1End = new Point();
                Point V2Start = new Point();
                Point V2End = new Point();

                String str;
                str = v1SpointX1.getText();
                V1Start.x = Integer.parseInt(str);
                str = v1SpointY1.getText();
                V1Start.y = Integer.parseInt(str);


                str = v1EpointX2.getText();
                V1End.x = Integer.parseInt(str);
                str = v1EpointY2.getText();
                V1End.y = Integer.parseInt(str);


                str = v2SpointX1.getText();
                V2Start.x = Integer.parseInt(str);
                str = v2SpointY1.getText();
                V2Start.y = Integer.parseInt(str);


                str = v2EpointX2.getText();
                V2End.x = Integer.parseInt(str);
                str = v2EpointY2.getText();
                V2End.y = Integer.parseInt(str);

                VectorFromCoordinates v1 =
                        new VectorFromCoordinates(new VectorFromPoints(new Point(V1Start.x,V1Start.y), new Point(V1End.x,V1End.y)));
                VectorFromCoordinates v2 =
                        new VectorFromCoordinates(new VectorFromPoints(new Point(V2Start.x,V2Start.y), new Point(V2End.x,V2End.y)));
                VectorFromCoordinates v3 = new VectorFromCoordinates();
                v3 = sumVectors(v1,v2);

                res.setText("{"+v3.getX()+"; "+v3.getY()+"}");
                FrameRes.setVisible(true);

            }
        });


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point V1Start = new Point();
                Point V1End = new Point();
                Point V2Start = new Point();
                Point V2End = new Point();

                String str;
                str = v1SpointX1.getText();
                V1Start.x = Integer.parseInt(str);
                str = v1SpointY1.getText();
                V1Start.y = Integer.parseInt(str);


                str = v1EpointX2.getText();
                V1End.x = Integer.parseInt(str);
                str = v1EpointY2.getText();
                V1End.y = Integer.parseInt(str);


                str = v2SpointX1.getText();
                V2Start.x = Integer.parseInt(str);
                str = v2SpointY1.getText();
                V2Start.y = Integer.parseInt(str);


                str = v2EpointX2.getText();
                V2End.x = Integer.parseInt(str);
                str = v2EpointY2.getText();
                V2End.y = Integer.parseInt(str);

                VectorFromCoordinates v1 =
                        new VectorFromCoordinates(new VectorFromPoints(new Point(V1Start.x,V1Start.y), new Point(V1End.x,V1End.y)));
                VectorFromCoordinates v2 =
                        new VectorFromCoordinates(new VectorFromPoints(new Point(V2Start.x,V2Start.y), new Point(V2End.x,V2End.y)));
                VectorFromCoordinates v3 = new VectorFromCoordinates();
                v3 = subVectors(v1,v2);

                res.setText("{"+v3.getX()+"; "+v3.getY()+"}");
                FrameRes.setVisible(true);

            }
        });


        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point V1Start = new Point();
                Point V1End = new Point();
                Point V2Start = new Point();
                Point V2End = new Point();

                String str;
                str = v1SpointX1.getText();
                V1Start.x = Integer.parseInt(str);
                str = v1SpointY1.getText();
                V1Start.y = Integer.parseInt(str);


                str = v1EpointX2.getText();
                V1End.x = Integer.parseInt(str);
                str = v1EpointY2.getText();
                V1End.y = Integer.parseInt(str);


                str = v2SpointX1.getText();
                V2Start.x = Integer.parseInt(str);
                str = v2SpointY1.getText();
                V2Start.y = Integer.parseInt(str);


                str = v2EpointX2.getText();
                V2End.x = Integer.parseInt(str);
                str = v2EpointY2.getText();
                V2End.y = Integer.parseInt(str);

                VectorFromCoordinates v1 =
                        new VectorFromCoordinates(new VectorFromPoints(new Point(V1Start.x,V1Start.y), new Point(V1End.x,V1End.y)));
                VectorFromCoordinates v2 =
                        new VectorFromCoordinates(new VectorFromPoints(new Point(V2Start.x,V2Start.y), new Point(V2End.x,V2End.y)));

                res.setText(String.valueOf(multiplicationVectors(v1,v2)));
                FrameRes.setVisible(true);
            }
        });


        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Point V1Start = new Point();
                Point V1End = new Point();
                Point V2Start = new Point();
                Point V2End = new Point();

                String str;
                str = v1SpointX1.getText();
                V1Start.x = Integer.parseInt(str);
                str = v1SpointY1.getText();
                V1Start.y = Integer.parseInt(str);


                str = v1EpointX2.getText();
                V1End.x = Integer.parseInt(str);
                str = v1EpointY2.getText();
                V1End.y = Integer.parseInt(str);


                str = v2SpointX1.getText();
                V2Start.x = Integer.parseInt(str);
                str = v2SpointY1.getText();
                V2Start.y = Integer.parseInt(str);


                str = v2EpointX2.getText();
                V2End.x = Integer.parseInt(str);
                str = v2EpointY2.getText();
                V2End.y = Integer.parseInt(str);

                VectorFromCoordinates v1 =
                        new VectorFromCoordinates(new VectorFromPoints(new Point(V1Start.x,V1Start.y), new Point(V1End.x,V1End.y)));
                VectorFromCoordinates v2 =
                        new VectorFromCoordinates(new VectorFromPoints(new Point(V2Start.x,V2Start.y), new Point(V2End.x,V2End.y)));
                double angle = angleBetweenVectors(v1,v2);
                res.setText(String.format("%.2f",angle));
                FrameRes.setVisible(true);

            }
        });



    }
}
