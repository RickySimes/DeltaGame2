package org.academiadecodigo.gitbusters.objects.weapons;

import org.academiadecodigo.gitbusters.engine.Direction;
import org.academiadecodigo.gitbusters.engine.Field;
import org.academiadecodigo.gitbusters.engine.Position;
import org.academiadecodigo.gitbusters.objects.GameObject;
import org.academiadecodigo.gitbusters.objects.Moveable;
import org.academiadecodigo.gitbusters.objects.character.enemy.Enemy;

import java.util.ArrayList;

public abstract class Weapon extends GameObject implements Moveable {

    private boolean fired;
    private Position position;
    private Direction direction;
    private int speed;
    private ArrayList<Enemy> enemies;

    //private int bulletDamage;

    public Weapon(Position pos, Direction direction, int speed, String path, Field field) {

        this.position = new Position(pos.getX(),pos.getY(),field,path);
        this.direction = direction;
<<<<<<< HEAD
=======

>>>>>>> 3aa68310be063ce202b8ad56033b058d2625b878
        this.speed = speed;
    }

    public void setFired(boolean fired) {

        /*if (!fired) {
            this.fired = false;
            this.position.hide();
            return;
        }*/

        this.fired = fired;
        if (fired){
            this.position.show();
        }
    }

    public boolean isFired() {
        return fired;
    }

    public Direction getDirection() {
        return direction;
    }

    /*
    // if bullet hits enemy
    public boolean hasHitEnemy() {

        if (enemy.getPosition().getX() == bullet.getPosition().getX()) {
            return true;
        }
        return false;
    }*/

    // if hits wall
    public boolean hasHitWall(Field field) {
        if(this.getPosition().getMaxX() == field.getWidth() - Field.PADDING) {
            return true;
        }
        return false;
    }

    public void move(Field field) {
        switch (this.direction) {
            case UP:
                position.moveUp(speed);
                if(this.position.getY() == field.getY()) {
                    position.hide();
                }
                break;
            case DOWN:
                position.moveDown(speed);
                if(this.position.getMaxY() == field.getMaxY()) {
                    position.hide();
                }
                break;
            case LEFT:
                position.moveLeft(speed);
                if(this.position.getX() == field.getX()) {
                    position.hide();
                }
                break;
            case RIGHT:
                position.moveRight(speed);
                if(this.position.getMaxX() == field.getMaxX()) {
                    position.hide();
                }
                break;
        }

    }


    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public void setSpeed(int speed) {

    }

    @Override
    public void increaseSpeed() {}

    @Override
    public void decreaseSpeed() {}

    public boolean atEdge() {
        return false;
    }



    // depois metemos um construtor e tal...

   /* public void Shoot(Enemy enemy) {
        enemy.hit();
    }  */
}
