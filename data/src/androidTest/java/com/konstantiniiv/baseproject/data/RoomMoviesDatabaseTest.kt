package com.konstantiniiv.baseproject.data

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.konstantiniiv.baseproject.data.db.AppDatabase
import com.konstantiniiv.baseproject.data.db.MovieDao
import com.konstantiniiv.baseproject.data.utils.TestUtils
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Konstantin Ivanov
 * email :  ki@agileburo.com
 * on 28.05.2018.
 */
@RunWith(AndroidJUnit4::class)
class RoomMoviesDatabaseTest {

    private lateinit var database: AppDatabase
    private lateinit var moviesDao: MovieDao

    @Before
    fun init() {
        database = Room
                .inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                        AppDatabase::class.java).build()
        moviesDao = database.movieDao()
    }

    @After
    fun after() = database.close()

    @Test// save(1)
    fun testSingleInsertion() {
        val movieData = TestUtils.getTestMovieData(4520)
        moviesDao.insert(movieData)
        val result = moviesDao.get(4520)
        assertNotNull(result)
        assertEquals(4520, result?.id)
        assertEquals(110, result?.runtime)
    }

    @Test// save(1) - OnConflict.Replace
    fun testInsertionOnConflictReplace() {
        val movie1 = TestUtils.getTestMovieData(11)
        val movie2 = movie1.copy(nameOriginal = "I_Am_Copy")
        moviesDao.insert(movie1)
        moviesDao.insert(movie2)
        val result = moviesDao.get(11)
        assertEquals(11, result?.id)
        assertEquals("I_Am_Copy", result?.nameOriginal)
    }

    @Test// save(list)
    fun testListInsertion() {
        val movies = TestUtils.getListOfMovieData()
        moviesDao.insert(movies)
        val results = moviesDao.getAll()
        assertEquals(5, results.size)
    }

    @Test// save(list) - OnConflict.Replace
    fun testListInsertionOnConflictReplace() {
        val movies = TestUtils.getListOfMovieData()
        val moviesCopy = movies.toMutableList()
        moviesCopy.forEach { it.nameOriginal = "Copy#${it.id}" }
        moviesDao.insert(movies)
        moviesDao.insert(moviesCopy)
        val result = moviesDao.getAll()
        result.forEach {
            assertEquals("Copy#${it.id}", it.nameOriginal)
        }
    }

    @Test// remove(1)
    fun testSingleDeletion() {
        val movieData = TestUtils.getTestMovieData(4520)
        moviesDao.insert(movieData)
        val deleted = moviesDao.delete(movieData)
        assertEquals(1, deleted)
        assertEquals(0, moviesDao.getAll().size)
    }

    @Test// remove(list)
    fun testAddFiveMoviesThenDeleteFourOfThem() {
        val movies = TestUtils.getListOfMovieData()
        val toDelete = movies.toMutableList()
        toDelete.removeAt(0)
        moviesDao.insert(movies)
        val deleted = moviesDao.delete(toDelete)
        val result = moviesDao.getAll()
        assertEquals(4, deleted)
        assertEquals(1, result.size)
        assertEquals(result[0].id, 0)
        assertEquals(result[0].nameOriginal, "Title#0")
        assertEquals(110, result[0].runtime)
    }

    @Test// remove(null)
    fun testDeleteNotInDatabaseObject() {
        val movie = TestUtils.getTestMovieData(11)
        val result = moviesDao.delete(movie)
        assertEquals(0, result)
    }

    @Test// clear()
    fun testListDeletion() {
        val movies = TestUtils.getListOfMovieData()
        moviesDao.insert(movies)
        moviesDao.deleteAll()
        val results = moviesDao.getAll()
        assertEquals(0, results.size)
    }

    @Test// get(movieId)
    fun testGetSingleById() {
        val movie = TestUtils.getTestMovieData(452077)
        moviesDao.insert(movie)
        val result = moviesDao.get(452077)
        assertEquals(452077, result?.id)
        assertEquals("Title#452077", result?.nameOriginal)
    }

    @Test// getAll()
    fun testGetAll() {
        val movies = TestUtils.getListOfMovieData()
        moviesDao.insert(movies)
        val result = moviesDao.getAll()
        assertEquals(movies.size, result.size)
        result.forEach {
            assertEquals("Title#${it.id}", it.nameOriginal)
        }
    }

    @Test
    fun testGetNullableObject() {
        val result = moviesDao.get(423432)
        assertNull(result)
    }
}