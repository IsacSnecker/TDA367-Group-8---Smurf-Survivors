package com.smurfsurvivors.game.model.weapons;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.smurfsurvivors.game.model.entity.Entity;

public abstract class AbstractWeapon{
    Vector2 position;
    Vector2 originalPosition;
    public TextureRegion weaponTexture;
    float width;
    float height;
    float attackRange;
    int velocity;
    public int attackDamage;
    String weaponName;
    boolean removeMe = false;

    public AbstractWeapon(Vector2 _position, TextureRegion _weaponTexture, float _width, float _height, float _attackRange, int _velocity, int _attackDamage, String _weaponName){
        position = _position;
        originalPosition = new Vector2(_position.x, _position.y);
        weaponTexture = _weaponTexture;
        width = _width;
        height = _height;
        attackRange = _attackRange;
        velocity = _velocity;
        attackDamage = _attackDamage;
        weaponName = _weaponName;
    }
    abstract void update();
    public void performAttack() {
    }

    public Rectangle getPositionRectangle(){
        return new Rectangle(position.x, position.y, width, height);
    }

    public void moveTowardsEntity(Entity enemy){
        if(enemy.getX() < getX() && enemy.getY() < getY()){
            move(-velocity, -velocity);
        }
        else if(enemy.getX() < getX() && enemy.getY() > getY()){
            move(-velocity, velocity);
        }
        else if(enemy.getX() > getX() && enemy.getY() < getY()){
            move(velocity, -velocity);
        }
        else if(enemy.getX() > getX() && enemy.getY() > getY()) {
            move(velocity, velocity);
        }
        else if(enemy.getX() > getX()){
            move(velocity, 0);
        }
        else if(enemy.getY() > getY()){
            move(0, velocity);
        }
        else if(enemy.getX() < getX()){
            move(-velocity, 0);
        }
        else if(enemy.getY() < getY()){
            move(0, -velocity);
        }
    }

    public void moveTowardsPosition(Vector2 position){
        float differenceX = position.x - getX();
        float differenceY = position.y - getY();
        float dx;
        float dy;
        float radianDegree;
        if(differenceX > 0 && differenceY > 0){
            radianDegree = calculateRadianDegree(differenceX, differenceY);
            dx = calculatedx(radianDegree);
            dy = calculatedy(radianDegree);
            move(dx, dy);
        }
        else if(differenceX > 0 && differenceY < 0){
            radianDegree = calculateRadianDegree(differenceX, -differenceY);
            dx = calculatedx(radianDegree);
            dy = calculatedy(radianDegree);
            move(dx, -dy);
        }
        else if(differenceX < 0 && differenceY > 0){
            radianDegree = calculateRadianDegree(-differenceX, differenceY);
            dx = calculatedx(radianDegree);
            dy = calculatedy(radianDegree);
            move(-dx, dy);
        }
        else if(differenceX < 0 && differenceY < 0){
            radianDegree = calculateRadianDegree(-differenceX, -differenceY);
            dx = calculatedx(radianDegree);
            dy = calculatedy(radianDegree);
            move(-dx, -dy);
        }
    }

    private float calculateRadianDegree(float differenceX, float differenceY){
        return (float)Math.atan(differenceX/differenceY);
    }

    private float calculatedx(float radianDegree){
        return (float)(Math.sin(radianDegree)*velocity);
    }

    private float calculatedy(float radianDegree){
        return (float)(Math.cos(radianDegree)*velocity);
    }

    public void move(float dx, float dy){
        setX(getX() + dx);
        setY(getY() + dy);
    }

    public void render(SpriteBatch batch){
        batch.draw(weaponTexture, position.x, position.y, width, height, width, height, 1,1,180);
    }

    public float getX() {
        return position.x;
    }

    public void setX(float x){
        position = new Vector2(x, position.y);
    }

    public float getY() {
        return position.y;
    }

    public void setY(float y){
        position = new Vector2(position.x, y);
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(float attackRange) {
        this.attackRange = attackRange;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }
}
