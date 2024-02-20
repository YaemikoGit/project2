package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

// Author: Yuen Wee Kin, Edwin
// Purpose: IOManager that manage all inputs(mouse event and keyboard) and outputs(Sound)

public class IOManager {
	private Sound dropSound;
	private Music backgroundSound;

	IOManager() {
	}

	// Set background sound, function takes in a string value called URI.
	public void setBackgroundSound(String uri) {
		this.backgroundSound = (Music) Gdx.audio.newMusic(Gdx.files.internal(uri));
	}

	// If loop is true, we play the music forever.
	public void playBackgroundMusic(boolean loop) {
		this.backgroundSound.play();
		this.backgroundSound.setLooping(loop);
	}

	// Set the droplet sound.
	public void setDropSound(String dropSoundURI) {
		this.dropSound = (Sound) Gdx.audio.newSound(Gdx.files.internal(dropSoundURI));
	}

	// Get the drop sound.
	public Sound getDropSound() {
		return this.dropSound;
	}

	// Disposed all created sounds.
	public void dispose() {
		this.dropSound.dispose();
		this.backgroundSound.dispose();
	}
}
